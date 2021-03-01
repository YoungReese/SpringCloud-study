package com.ly.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true) // 开启链式写法
public class Dept {
    /**
     * 主键
     */
    private Long deptNo;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 这个数据保存在哪个数据库
     * 一般一个微服务对应一个数据库
     */
    private String dbSource;

    public Dept(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 链式写法
     */

}
