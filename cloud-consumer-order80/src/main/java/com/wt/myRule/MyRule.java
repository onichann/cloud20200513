package com.wt.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @date 2020-06-04 下午 5:12
 * introduction
 */
@Configuration
public class MyRule {

    @Bean
    public IRule myIRule() {
        return new RandomRule();
    }
}
