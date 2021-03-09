package com.ly.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { //@Configuration <=> spring中applicationContext.xml

    /**
     * 配置负载均衡实现RestTemplate
     * IRule：
     * RoundRobinRule：轮询
     * RandomRule：随机
     * AvailabilityFilteringRule：会先过滤掉跳闸和访问故障的服务~，对剩下的进行轮询~
     * RetryRule：会先按照轮询获取服务~，如果服务获取失败，则会在指定的时间内进行，重试
     */
    @Bean(name = "remoteRestTemplate")
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 默认是轮询算法，可以在这里改成其他算法
     *
     * 一般不放在这里，因为直接被扫描，当有多个自实现轮询算法时都会被加载（可能会冲突）
     * 我们希望在主启动类中选择加载某一个具体的，而不是加载全部的
     *
     * 主启动类加载方式：@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = LYRule.class)
     *
     * 因此这里测试完之后，注销掉，将轮询算法配置放在rule包下面
     */
//    @Bean
//    public IRule myRule() {
//        return new RandomRule();
//    }
}
