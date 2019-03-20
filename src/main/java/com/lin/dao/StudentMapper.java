package com.lin.dao;

import com.lin.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    /**
     * 演示mybatis的基本用法
     * 增删改查，输入类型，输出类型
     */
    void insert(Student student);//传入类型为实体

    void delete(Map map);//k-v:参数名及对应的值

    void update(@Param("studentId") String studentId, @Param("studentName") String studentName );//注解传参，相当于map的键值对

    Student select(String studentId);//字符串传参，返回值为实体类型

    List<Student> selectSelective();//返回值类型为List--每一个元素都是一个实体对象

    Map<String,Object> selectMulti();//返回值为多个字段，且不属于同一个实体

    List<Map<String,Object>> selectMultiList();//返回值为多条数据，每条数据包含多个字段，且这些字段不属于同一实体
}
