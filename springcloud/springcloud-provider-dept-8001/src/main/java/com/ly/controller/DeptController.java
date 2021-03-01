package com.ly.controller;

import com.ly.pojo.Dept;
import com.ly.service.DeptService;
import com.ly.service.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @GetMapping("/")
    public String hello() {
        return "hello, it's ok !";
    }

    @Autowired
    private DeptService deptService;

//    //获取一些配置的信息，得到具体的微服务！
//    @Autowired
//    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) { //@RequestBody
        System.out.println("/dept/add");
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw new RuntimeException("Fail");
        }
        return dept;
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

//    //注册进来的微服务~，获取一些消息~
//    @GetMapping("/dept/discovery")
//    public Object discovery() {
//        //获取微服务列表的清单
//        List<String> services = client.getServices();
//        System.out.println("discovery=>services:" + services);
//
//        //得到一个具体的微服务信息,通过具体的微服务id，applicationName；
//        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
//
//        for (ServiceInstance instance : instances) {
//            System.out.println(
//                    instance.getHost() + "\t" +
//                            instance.getPort() + "\t" +
//                            instance.getUri() + "\t" +
//                            instance.getServiceId()
//
//            );
//        }
//        return this.client;
//    }

}
