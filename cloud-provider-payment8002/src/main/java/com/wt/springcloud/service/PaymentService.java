package com.wt.springcloud.service;


import com.wt.springcloud.entity.Payment;

/**
 * @auther zzyy
 * @create 2020-02-18 10:40
 */
public interface PaymentService {
    public boolean create(Payment payment);

    public Payment getPaymentById(Long id);
}

