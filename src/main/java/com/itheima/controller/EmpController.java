package com.itheima.controller;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    // 注解后面不能直接跟大括号——注解是"贴在方法上的标签",方法写在下一段
    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        // @RequestParam:接收 url 问号后面的 query 参数(?page=2&pageSize=5)
        // defaultValue:前端不传时的兜底值
        // 多个参数之间用"逗号"分隔(你写成 page.pageSize,点是调用成员,逗号才是参数分隔)
        PageBean pageBean = empService.page(page, pageSize);
        return Result.success(pageBean);
    }
}
