package com.wt.springcloud.alibaba.service;

import com.wt.springcloud.alibaba.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
  *@author wutong
  *@date 2021/2/23 22:29
  *introduction 
 */
    
public interface OrderService extends IService<Order>{

    void create(Order order);
}
