package com.ly.dao;

import com.ly.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    boolean addDept(Dept dept);

    Dept queryById(Long id);

    @Select("select * from dept")
    List<Dept> queryAll();

}
