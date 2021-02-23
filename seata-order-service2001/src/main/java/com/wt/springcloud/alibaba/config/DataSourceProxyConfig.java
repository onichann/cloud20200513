package com.wt.springcloud.alibaba.config;

import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author wutong
 * @date 2021/2/22 22:23
 * introduction
 */
@Configuration
public class DataSourceProxyConfig {

    @Bean
    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }
}
