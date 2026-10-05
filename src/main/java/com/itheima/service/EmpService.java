package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;

public interface EmpService {

    /**
     * 分页查询员工
     * @param page 第几页(从1开始)
     * @param pageSize 每页几条
     */
    PageBean page(String name,Integer gender,LocalDate begin,LocalDate end, Integer page, Integer pageSize);
    void save(Emp emp);
}
