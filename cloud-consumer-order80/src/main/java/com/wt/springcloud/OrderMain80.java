package com.wt.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.Duration;

/**
 * @author Administrator
 * @date 2020-05-18 下午 3:15
 * description
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name ="CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }

    @Autowired
    private RestTemplateBuilder builder;

    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate= builder.setConnectTimeout(Duration.ofMillis(100000)).setReadTimeout(Duration.ofMillis(100000)).build();
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return true;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        });
        return restTemplate;
    }
}
