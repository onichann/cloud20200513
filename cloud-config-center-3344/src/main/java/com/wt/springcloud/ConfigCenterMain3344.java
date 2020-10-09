package com.wt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author wutong
 * @date 2020/10/9 10:45
 * introduction
 */
@SpringBootApplication
@EnableConfigServer
/**
 * https://docs.spring.io/spring-cloud-config/docs/2.2.5.RELEASE/reference/html/
 * 可以集群配置
 */
public class ConfigCenterMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
