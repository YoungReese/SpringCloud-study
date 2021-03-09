package com.ly.service;

import com.ly.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

// 降级
//@Component
public class DeptClientServiceFallbackFactory /*implements FallbackFactory*/ {
//    @Override
//    public Object create(Throwable throwable) {
//        return new DeptClientService() {
//
//            @Override
//            public Dept queryById(Long id) {
//                return new Dept()
//                        .setDeptNo(id)
//                        .setDeptName("id=>"+id+"没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭")
//                        .setDbSource("没有数据~");
//            }
//
//            @Override
//            public List<Dept> queryAll() {
//                return null;
//            }
//
//            @Override
//            public boolean addDept(Dept dept) {
//                return false;
//            }
//
//        };
//    }
}
