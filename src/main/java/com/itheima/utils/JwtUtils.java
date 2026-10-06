package com.itheima.utils;

// ===== 双遍法:凭印象重写JWT工具类 =====
// 两个常量: SECRET密钥("itheima") / EXPIRE有效期(1小时=3600_000L毫秒)
//
// generateJwt(Map claims) 造票链(你的原注释):
//   制造门票的机器 → 写入数据 → 算法加密 → 设定时效 → 转换成字符串类型
//
// parseJwt(String jwt) 验票链(你的原注释):
//   检验门票的机器 → 解码 → 核对 → 返回数据
//   只有两种结局:返回Map 或 抛异常(没有返回null!)
//
// 自问:两个方法为什么是static?(公共工具贴墙上,不用从仓库领)

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final String SECRET="itheima";
    private static final long EXPIRE_TIME=3600_000L;
    public static String generateJwt(Map<String,Object> claims){

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE_TIME))
                .compact();
    }

    public static Map<String ,Object> parseJwt(String jwt) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
