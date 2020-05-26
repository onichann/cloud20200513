package com.wt.springcloud.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.springcloud.entity.Payment;
import com.wt.springcloud.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
  *@author Administrator
  *@date 2020-05-17 下午 10:35
  *description 
 */
    
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService{

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public boolean create(Payment payment) {
        return save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return getById(id);
    }
}
