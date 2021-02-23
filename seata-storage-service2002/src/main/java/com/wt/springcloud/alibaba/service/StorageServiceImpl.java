package com.wt.springcloud.alibaba.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.springcloud.alibaba.domain.Storage;
import com.wt.springcloud.alibaba.mapper.StorageMapper;

/**
  *@author wutong
  *@date 2021/2/23 23:37
  *introduction 
 */
    
@Service
@Slf4j
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService{


    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        Storage storage = getOne(new QueryWrapper<Storage>().eq(Storage.COL_PRODUCT_ID, productId));
        storage.setUsed(storage.getUsed()+count);
        storage.setResidue(storage.getResidue()-count);
        update(storage, new QueryWrapper<Storage>().eq(Storage.COL_PRODUCT_ID, productId));
        log.info("------->storage-service中扣减库存结束");

    }
}
