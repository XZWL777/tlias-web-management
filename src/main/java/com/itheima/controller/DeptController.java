package com.itheima.controller;


import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired//注入对象
    private DeptService deptService;
    @GetMapping("/depts")
    public Result list(){
        List<Dept> depts = deptService.list();
        return Result.success(depts);//需要一个对象调用list方法来返回值给service层

    }
    @DeleteMapping("/depts")
    public Result deleteById(Integer id){
        deptService.deleteById(id);
        return Result.success();
    }
    @PostMapping("/depts")
    public Result insert(@RequestBody Dept dept){
        deptService.insert(dept);
        return Result.success();
    }
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }
    @GetMapping("/depts/{id}")
    public Result getById(@PathVariable Integer id){
        return Result.success(deptService.getById(id));
    }



}
