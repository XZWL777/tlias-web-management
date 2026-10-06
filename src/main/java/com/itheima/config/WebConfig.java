package com.itheima.config;

// ===== 双遍法:凭印象重写排班表 =====
// 你的原注释线索:
//   @Configuration + 实现 WebMvcConfigurer
//   @Autowired private TokenInterceptor(它是bean可以注入;private=内部零件)
//   重写 addInterceptors(registry登记表):
//     添加拦截器 → 添加阻拦路径 /**(全部路径) → 排除login路径
// 警告: "/login"引号里不能有空格;登记的是bean对象,不是请求头字符串token

import com.itheima.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private TokenInterceptor tokenInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
    }

}
