package com.ly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


/**
 * liyang 2021-03-10
 * dashboard 监控页面 http://localhost:9001/hystrix
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumerDashboard_9001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashboard_9001.class, args);
    }

}