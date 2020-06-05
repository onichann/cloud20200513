package com.wt.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 * @date 2020-06-05 上午 10:19
 * introduction
 */
@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger nextServerCyclicCounter;

    public MyLB() {
        this.nextServerCyclicCounter = new AtomicInteger(0);;
    }

    public final int incrementAndGet() {
        int current;
        int next;
        do {
            current = nextServerCyclicCounter.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!nextServerCyclicCounter.compareAndSet(current, next));
        System.out.println("*****第几次访问，次数next: "+next);
        return next;
    }

    @Override
    public ServiceInstance choose(List<ServiceInstance> serviceInstances) {
        return serviceInstances.get(incrementAndGet()%serviceInstances.size());
    }
}
