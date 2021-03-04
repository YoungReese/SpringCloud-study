package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LYRule {
    @Bean
    public IRule myRule(){
        return new RoundRobinRule();  // 默认是轮询，可以定义成一个 LYRandomRule
    }
}
