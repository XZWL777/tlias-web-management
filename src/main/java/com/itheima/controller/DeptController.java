package com.itheima.controller;


import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired//注入对象
    private DeptService deptService;
    @GetMapping("/depts")
    public Result list(){
        List<Dept> depts = deptService.list();
        return Result.success(depts);            //需要一个对象调用list方法来返回值给service层
    }
    @DeleteMapping("/depts")
    public Result deleteById(Integer id){
        deptService.deleteById(id);
        return Result.success();
    }


}
