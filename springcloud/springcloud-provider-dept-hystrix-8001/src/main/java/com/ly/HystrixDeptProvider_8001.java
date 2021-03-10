package com.ly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient      // 在服务启动后自动注册到Eureka中
@EnableDiscoveryClient   // 让服务发现自己
@EnableCircuitBreaker    // 开启熔断器支持
public class HystrixDeptProvider_8001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDeptProvider_8001.class, args);
    }

}