package com.itheima.service;

import com.itheima.pojo.PageBean;

public interface EmpService {

    /**
     * 分页查询员工
     * @param page 第几页(从1开始)
     * @param pageSize 每页几条
     */
    PageBean page(Integer page, Integer pageSize);
}
