package com.ly;

import com.rule.LYRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

// Ribbon 和 Eureka 整合以后，客户端可以直接待用服务的名字（替代原来的IP地址+端口号），并且可以实现负载均衡
@SpringBootApplication
@EnableEurekaClient
// 在微服务启动的时候就能去加载我们自定义Ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = LYRule.class)
public class DeptConsumer_80 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }

}
