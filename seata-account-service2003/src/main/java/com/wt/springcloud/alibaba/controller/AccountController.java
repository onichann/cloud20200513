package com.wt.springcloud.alibaba.controller;

import com.wt.springcloud.alibaba.domain.CommonResult;
import com.wt.springcloud.alibaba.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author wutong
 * @date 2021/2/24 17:16
 * introduction
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 扣减账户余额
     */
    public CommonResult<?> describe(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult<>(200,"扣减账户余额成功！");
    }
}
