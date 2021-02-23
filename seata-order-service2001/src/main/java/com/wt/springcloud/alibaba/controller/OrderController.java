package com.wt.springcloud.alibaba.controller;

import com.wt.springcloud.alibaba.domain.CommonResult;
import com.wt.springcloud.alibaba.domain.Order;
import com.wt.springcloud.alibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wutong
 * @date 2021/2/23 15:33
 * introduction
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<?> create(Order order) {
        orderService.create(order);
        return new CommonResult<>(200, "订单创建成功");
    }
}
