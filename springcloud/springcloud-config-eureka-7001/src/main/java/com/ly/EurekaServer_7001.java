package com.ly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * liyang 2021-03-11
 * 改造自springcloud-eureka-7001，但是配置信息通过 springcloud-config-server-3344 在git上拿
 */
@SpringBootApplication
@EnableEurekaServer  // Eureka服务端（服务注册中心）启动类，启动之后，访问 http://localhost:7001/
public class EurekaServer_7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7001.class, args);
    }

}
