package com.itheima.controller;

// ===== 双遍法:凭印象重写登录Controller =====
// 流程提示(不许翻git,卡壳才准看):
// 1. 类注解:成为接收请求的Controller
// 2. 注入 EmpService
// 3. @PostMapping 路径(警告:不是 /emps/login)
// 4. 参数:@RequestBody 收整个JSON成一个Emp(不能拆成两个String!)
// 5. 查不到(null)→ Result.error("用户名或者密码错误")
// 6. 查到 → Map装id和username → 造票 → Result.success(jwt)
// 7. JwtUtils是static工具类:类名直接调,不能@Autowired

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
 @Autowired
 EmpService empService;
 @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
     Emp e = empService.login(emp);
     Map<String,Object> map=new HashMap<>();
     if(e==null){
         return Result.error("用户名或者密码错误");
     }else{

     map.put("id",e.getId());
     map.put("username",e.getUsername());
     String jwt=JwtUtils.generateJwt(map);
     return Result.success(jwt);
 }
}}
