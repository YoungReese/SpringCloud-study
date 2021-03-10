package com.ly.service;

import com.ly.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * liyang 2021-03-10
 * 用于Hystrix服务降级
 *
 * 之前服务熔断用来处理一个接口，每个接口都需要备选方案，比较麻烦，治理通过服务降级处理一个类
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {

            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setDeptNo(id)
                        .setDeptName("id=>" + id + "没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭")
                        .setDbSource("没有数据");
            }

            @Override
            public List<Dept> queryAll() {
                Dept dept = new Dept()
                        .setDeptNo(-1L)
                        .setDeptName("没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭")
                        .setDbSource("没有数据");
                List<Dept> deptList = new ArrayList<>();
                deptList.add(dept);
                return deptList;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

        };
    }
}
