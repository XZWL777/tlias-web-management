package com.itheima.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Date;


public class JwtUtils {
    private static final String SECRET = "itheima";
    private static final long EXPIRE=3600_000L;

    public static String generateJwt(Map<String,Object> claims){
        return Jwts.builder()//制造门票的机器
                .setClaims(claims)//写入数据
                .signWith(SignatureAlgorithm.HS256,SECRET)//算法加密
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))//设定时效
                .compact();//转换成字符串类型
    }

    public static Map<String,Object> parseJwt(String jwt){
        return Jwts.parser()//检验门票的机器
                .setSigningKey(SECRET)//解码
                .parseClaimsJws(jwt)//核对
                .getBody();//返回数据
    }
}
