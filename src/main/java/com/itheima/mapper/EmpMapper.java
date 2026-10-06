package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper   // 别忘了!(你漏了,没有它 MyBatis 不会生成实现类)
public interface EmpMapper {

    // 分页查询:你只管写 select *,PageHelper 会自动改写成 limit 分页
    // 注意:多参数必须加 @Param,否则 XML 里 #{name} 和 test="name != null" 取不到值
    List<Emp> list(@Param("name") String name,
                   @Param("gender") Integer gender,
                   @Param("begin") LocalDate begin,
                   @Param("end") LocalDate end);   // 返回员工列表,不是 void


    @Options(useGeneratedKeys = true, keyProperty = "id")  // insert后,自增id自动塞回emp.id
    @Insert("insert into emp (username,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    // 双遍法任务:按用户名+密码查员工
    // 提醒: select * 不是 select 两列;列名拼写(usenname这种错别再犯)
    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp login(Emp emp);

}
