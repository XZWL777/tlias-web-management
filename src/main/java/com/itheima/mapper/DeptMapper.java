package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//mybatis写法 DeptMapper接口,这是增删改查的查表语句
@Mapper
public interface DeptMapper {
    @Select("select id,name,create_time,update_time from dept order by update_time desc")
    List<Dept> list();
    @Delete("delete from dept where id=#{id} ")
    void deleteById(Integer id);
}
