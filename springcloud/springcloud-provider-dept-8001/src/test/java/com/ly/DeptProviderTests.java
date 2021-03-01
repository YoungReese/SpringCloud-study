package com.ly;

import com.ly.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class DeptProviderTests {


    @Autowired
    private DeptService deptService;

    @Test
    public void testQueryUsers() {
        System.out.println(deptService.queryAll());
    }

}
