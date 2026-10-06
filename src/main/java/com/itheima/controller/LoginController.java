package com.itheima.controller;


import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        Emp e=empService.login(emp);
       if(e==null){
           return Result.error("用户名或者密码错误");
       }
        Map<String,Object> claims=new HashMap<>();
       claims.put("id",e.getId());
       claims.put("username",e.getUsername());
       String jwt=JwtUtils.generateJwt(claims);
        return Result.success(jwt);
    }
}
