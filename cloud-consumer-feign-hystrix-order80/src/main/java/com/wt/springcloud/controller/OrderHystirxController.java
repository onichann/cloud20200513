package com.wt.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wt.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wutong
 * @date 2020/9/1 15:21
 * introduction
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystirxController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_OK(id);
        int i = 10 / 0;
        return result;
    }

    /**
     * feign:
     *   hystrix:
     *     enabled: false 的时候  以payment端降级方法返回（如果payment端降级情况）
     *
     *     enable:true的时候
     *     PaymentHystrixService#paymentInfo_TimeOut(Integer) timed-out and no fallback available.
     *     看样子需要提供降级方法 openFeign 降级 (原因是因为ribbon超时没设置所以出发错误进行降级了)
     *     已经测试 可以提供openFeign降级 或者 不提供openFeign的提供全局异常 或者提供@hystrixCommand标准的有fallbackMethod的
     *
     *     标准的和openFeign的都开 标准的优先(错误，降级只对当前方法降级，远程有错误，openfeign已经返回降级后的结果了)
     *
     *     注意ribbon有超时、feign有超时、hystrix（openfeign内部远程调用的）超时
     *
     *     假定服务端运行5s,降级时间2s  。客户端openfeign内部histrix默认好像就1s，需要设置hystrix，客户端超时4s，运行时常=openfeign远程调用时间+自己休眠时间
     *     测试后是可以的 2020/09/02 参考资料 https://www.cnblogs.com/WaterGe/p/11687118.html
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")
    })
    //@HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = null;
        result = paymentHystrixService.paymentInfo_TimeOut(id);
//        int i=10/0;
        try {
            TimeUnit.SECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id,Throwable throwable)
    {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }


    // 下面是全局fallback方法
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }


}
