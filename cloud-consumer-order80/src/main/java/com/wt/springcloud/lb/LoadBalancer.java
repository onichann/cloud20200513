package com.wt.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-06-05 上午 10:18
 * introduction
 */
public interface LoadBalancer {
    ServiceInstance choose(List<ServiceInstance> serviceInstances);
}
