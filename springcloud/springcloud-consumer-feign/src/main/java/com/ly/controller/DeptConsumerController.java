package com.ly.controller;

import com.ly.pojo.Dept;
import com.ly.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * liyang 2021-03-10
 * feign风格的调用方式：面向接口编程风格
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;

    @PostMapping("/consumer/dept/add")
    public boolean add(@RequestBody Dept dept) {
//        System.out.println("/consumer/dept/add");
        return deptClientService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.queryById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return deptClientService.queryAll();
    }


    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/log")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("springcloud-provider-dept");
        System.out.println(serviceInstance.getServiceId() + serviceInstance.getHost() + serviceInstance.getPort());
    }


}
