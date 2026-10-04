package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void deleteById(Integer id);

    void insert(Dept dept);

    void update(Dept dept);

    Object getById(Integer id);
}