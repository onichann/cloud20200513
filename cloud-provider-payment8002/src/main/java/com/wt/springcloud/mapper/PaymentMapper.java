package com.wt.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wt.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
  *@author Administrator
  *@date 2020-05-17 下午 10:35
  *description 
 */
    
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {

}