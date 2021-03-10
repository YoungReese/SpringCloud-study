package com.ly.controller;

import com.ly.pojo.Dept;
import com.ly.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    private static Logger logger = LoggerFactory.getLogger("DeptController");

    @Autowired
    private DeptService deptService;

    @GetMapping("/")
    public String hello() {
        logger.info("hello, it's ok!");
        System.out.println("hello, it's ok!");
        return "hello, it's ok!";
    }

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) { //@RequestBody
        System.out.println("/dept/add");
        return deptService.addDept(dept);
    }

    /*************************************************************************/
    /**
     * 这里仅将此方法加了熔断机制，展示了Hystrix的使用方法
     */
    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw new RuntimeException("Fail");
        }
        return dept;
    }

    //备选方法
    public Dept hystrixGet(@PathVariable("id") Long id) {
        return new Dept()
                .setDeptNo(id)
                .setDeptName("id => " + id + "没有对应的信息--null--@Hystrix")
                .setDbSource("No data in MySQL");
    }

    /*************************************************************************/

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        logger.info("/dept/list");
        System.out.println("/dept/list");
        return deptService.queryAll();
    }



    // 获取一些配置的信息，得到具体的微服务！
    @Autowired
    private DiscoveryClient client;

    // 注册进来的微服务~，获取一些消息~
    @GetMapping("/dept/discovery")
    public Object discovery() {
        logger.info("/dept/discovery");
        // 获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);
        // 得到一个具体的微服务信息,通过具体的微服务id，applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                            instance.getPort() + "\t" +
                            instance.getUri() + "\t" +
                            instance.getServiceId()
            );
        }
        return this.client;
    }

}