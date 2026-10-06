package com.itheima.interceptor;

// ===== 双遍法:凭印象重写令牌拦截器(保安) =====
// 你的原注释线索:
//   @Component —— 让spring识别管理
//   实现 HandlerInterceptor 接口,重写 preHandle(请求数据, 响应数据, handler)
//   获取请求头token → try里验票 → 不抛异常 return true(放行)
//   → 抛异常就响应 NOT_LOGIN(下划线!) 并 return false(轰走)
// 回忆: preHandle返回值是闸门 —— true放行 / false拦截

import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class TokenInterceptor implements HandlerInterceptor {
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
            try{String s=request.getHeader("token");
               Map<String,Object> map= JwtUtils.parseJwt(s);
            return true;
            }catch(Exception e){
                response.getWriter().write("NOT_LOGIN");
                return false;
            }
        }
}
