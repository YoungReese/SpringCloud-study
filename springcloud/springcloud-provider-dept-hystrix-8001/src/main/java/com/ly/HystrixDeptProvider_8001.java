package com.ly;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient      // 在服务启动后自动注册到Eureka中
@EnableDiscoveryClient   // 让服务发现自己
@EnableCircuitBreaker    // 开启熔断器支持
public class HystrixDeptProvider_8001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDeptProvider_8001.class, args);
    }

    /**
     * 增加一个 Servlet
     * 被dashboard监控的地址 http://localhost:8001/actuator/hystrix.stream
     */
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}
