package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper   // 别忘了!(你漏了,没有它 MyBatis 不会生成实现类)
public interface EmpMapper {

    // 分页查询:你只管写 select *,PageHelper 会自动改写成 limit 分页
    // 注意:注解后面不加分号(你模块2犯过,这次又犯了)
    @Select("select * from emp")
    List<Emp> list();   // 返回员工列表,不是 void
}
