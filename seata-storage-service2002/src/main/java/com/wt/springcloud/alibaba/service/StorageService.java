package com.wt.springcloud.alibaba.service;

import com.wt.springcloud.alibaba.domain.Storage;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
  *@author wutong
  *@date 2021/2/23 23:37
  *introduction 
 */
    
public interface StorageService extends IService<Storage>{

        /**
         * 扣减库存
         */
        void decrease(Long productId, Integer count);
}
