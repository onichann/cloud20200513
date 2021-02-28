package com.wt.springcloud.alibaba.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.springcloud.alibaba.domain.Account;
import com.wt.springcloud.alibaba.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
  *@author wutong
  *@date 2021/2/24 17:15
  *introduction 
 */
    
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService{

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        Account account = getOne(new QueryWrapper<Account>().eq(Account.COL_USER_ID, userId));
        account.setResidue(account.getResidue().subtract(money));
        account.setUsed(account.getUsed().add(money));
        updateById(account);
        log.info("------->account-service中扣减账户余额结束");
    }
}
