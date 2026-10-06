package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    /**
     * 分页查询员工
     * @param page 第几页(从1开始)
     * @param pageSize 每页几条
     */
    PageBean page(String name,Integer gender,LocalDate begin,LocalDate end, Integer page, Integer pageSize);
    void save(Emp emp);

    // 双遍法任务:声明login方法 —— 收Emp,返回Emp(查不到返回null,不是List!)
    Emp login(Emp emp);
}
