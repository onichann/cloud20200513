package com.wt.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wt.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.wt.springcloud.entity.CommonResult;
import com.wt.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wutong
 * @date 2021/1/7 14:15
 * introduction
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult<Payment> byResource() {
//        int age = 10/0;
        return new CommonResult<>(200, "按资源名称限流测试OK", new Payment("2020L", "001"));
    }

    public CommonResult<?> handleException(BlockException exception)
    {
        return new CommonResult<>(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource("byUrl")
    public CommonResult<?> byUrl() {
        return new CommonResult<>(200, "按url限流测试OK", new Payment("2020L", "serial002"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public CommonResult<Payment> customerBlockHandler() {
        return new CommonResult<>(200, "按客戶自定义", new Payment("2020L", "serial003"));
    }

}
