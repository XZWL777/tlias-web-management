package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    // 注解后面不能直接跟大括号——注解是"贴在方法上的标签",方法写在下一段
    @GetMapping("/emps")
    public Result page(String name,
            Integer gender,
            @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate end,
            @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        // @RequestParam:接收 url 问号后面的 query 参数(?page=2&pageSize=5)
        // defaultValue:前端不传时的兜底值
        // 多个参数之间用"逗号"分隔(你写成 page.pageSize,点是调用成员,逗号才是参数分隔)
        PageBean pageBean = empService.page(name, gender, begin, end, page, pageSize);
        return Result.success(pageBean);
    }
    @PostMapping("/emps")
    public Result save(@RequestBody Emp emp) {
        empService.save(emp);
        return Result.success();
    }
}
