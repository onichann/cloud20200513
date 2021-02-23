package com.wt.springcloud.alibaba.service;

import com.wt.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wutong
 * @date 2021/2/23 22:40
 * introduction
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonResult<?> decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
