package com.wt.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.wt.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        return result;
    }

    /**
     * feign:
     *   hystrix:
     *     enabled: false 的时候  以payment端降级方法返回（如果payment端降级情况）
     *
     *     enable:true的时候
     *     PaymentHystrixService#paymentInfo_TimeOut(Integer) timed-out and no fallback available.
     *     看样子需要提供降级方法 openFeign 降级
     *     已经测试 可以提供openFeign降级 或者 不提供openFeign的提供全局异常 或者提供@hystrixCommand标准的有fallbackMethod的
     *
     *     标准的和openFeign的都开 标准的优先
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = null;
        result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id)
    {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }


    // 下面是全局fallback方法
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }


}
