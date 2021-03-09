package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * liyang 2021-03-09
 * 这里可以单独配置ribbon负载均衡算法，需要时启用（在主启动类指定扫描）
 *
 * 注意：不要和主启动类同级，因为可以被自动扫描到，无法实现手动开启与关闭
 */
@Configuration
public class LYRule {
    @Bean
    public IRule myRule(){
        return new LYRandomRule();  // 默认是轮询，可以定义成一个 LYRandomRule
    }
}
