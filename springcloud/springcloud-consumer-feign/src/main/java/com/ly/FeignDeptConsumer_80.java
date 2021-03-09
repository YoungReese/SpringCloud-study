package com.ly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

// Ribbon 和 Eureka 整合以后，客户端可以直接待用服务的名字（替代原来的IP地址+端口号），并且可以实现负载均衡
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.ly"})
// @ComponentScan("com.ly") // 可以不加，因为 @SpringBootApplication 中有，默认扫描主启动类路径下的包
public class FeignDeptConsumer_80 {

    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class,args);
    }

}
