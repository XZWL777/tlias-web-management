package com.itheima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//Controller层注解
public class HelloController {//建立HelloController类

    @GetMapping("/hello")//获取请求.当请求为/hello时调用执行注解的方法
    public String hello() {//执行hello方法,返回字符串kkkk,给谁我不知道
        return "kkkk";
    }
}
