package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//mybatis写法 DeptMapper接口,这是增删改查的查表语句
@Mapper
public interface DeptMapper {
    @Select("select id,name,create_time,update_time from dept order by update_time desc")
    List<Dept> list();
    @Delete("delete from dept where id=#{id} ")
    void deleteById(Integer id);
    @Insert("insert into dept (name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
   @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
   void update(Dept dept);
   @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);
}
