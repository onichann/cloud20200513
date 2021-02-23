package com.wt.springcloud.alibaba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wt.springcloud.alibaba.domain.Storage;
import org.apache.ibatis.annotations.Mapper;

/**
  *@author wutong
  *@date 2021/2/23 23:37
  *introduction 
 */
    
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
}