package com.wt.springcloud.alibaba.service;

import com.wt.springcloud.entity.CommonResult;
import com.wt.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author wutong
 * @date 2021/1/29 11:07
 * introduction
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {

        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id+"","errorSerial"));
    }
}
