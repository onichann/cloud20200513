package com.wt.springcloud.alibaba.controller;

import com.wt.springcloud.alibaba.domain.CommonResult;
import com.wt.springcloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wutong
 * @date 2021/2/23 23:44
 * introduction
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public CommonResult<?> decrease(Long productId, Integer count) {
        storageService.decrease(productId,count);
        return new CommonResult<>(200, "扣减库存成功！");
    }
}
