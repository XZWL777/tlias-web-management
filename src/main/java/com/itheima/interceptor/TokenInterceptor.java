package com.itheima.interceptor;

import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component//让spring识别管理
public class TokenInterceptor implements HandlerInterceptor {//调用handlerinterceptor接口

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {//请求数据,响应数据,
        String jwt =request.getHeader("token");//获取请求头token,给字符串jwt

        try{//异常处理
            JwtUtils.parseJwt(jwt);//验票方法
            return true;//真
        }catch (Exception e){//爆异常
            response.getWriter().write("NOT_LOGIN");//响应数据为not-login
            return false;//假
        }
    }
}
