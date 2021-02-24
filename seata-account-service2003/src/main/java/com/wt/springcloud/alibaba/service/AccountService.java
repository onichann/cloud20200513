package com.wt.springcloud.alibaba.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.springcloud.alibaba.domain.Account;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
  *@author wutong
  *@date 2021/2/24 17:15
  *introduction 
 */
    
public interface AccountService extends IService<Account>{
        /**
         * 扣减账户余额
         * @param userId 用户id
         * @param money 金额
         */
        void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
