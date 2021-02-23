package com.wt.springcloud.alibaba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wt.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;

/**
  *@author wutong
  *@date 2021/2/23 22:29
  *introduction 
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}