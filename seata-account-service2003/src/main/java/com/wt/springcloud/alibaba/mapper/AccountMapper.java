package com.wt.springcloud.alibaba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wt.springcloud.alibaba.domain.Account;
import org.apache.ibatis.annotations.Mapper;

/**
  *@author wutong
  *@date 2021/2/24 17:15
  *introduction 
 */
    
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}