package com.ly.controller;

import com.ly.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    /**
     * 对于springcloud中的消费者模块不应该有service层，那么如何调用provider中的服务
     * RestTemplate：供我们调用，但需要注册到spring中
     * 参数一般形式：(url, 实体：Map ,Class<T> responseType)
     * 总结：RestTemplate提供多种便捷访问远程http服务的方法，简单的restful服务模版
     */
    @Autowired
    private RestTemplate restTemplate;

    //Ribbon。我们这里的地址，应该是一个变量，通过服务名来访问
    private static final String REST_URL_PREFIX = "http://localhost:8001";
//    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

//    @RequestMapping("/consumer/dept/add")
    @PostMapping("/consumer/dept/add")
    public boolean add(@RequestBody Dept dept) {
        System.out.println("/consumer/dept/add");
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }


}