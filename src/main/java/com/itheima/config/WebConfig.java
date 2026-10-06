package com.itheima.config;

import com.itheima.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;//为什么要私有

    @Override
    public void addInterceptors(InterceptorRegistry  registry) {
        registry.addInterceptor(tokenInterceptor)//添加拦截器tokenInterceptor,另外这个token跟interceptor里拿到的请求头token是一个吗
                .addPathPatterns("/**")//添加阻拦路径,**意思为全部路径
                .excludePathPatterns("/login");//排除login路径
    }
}
