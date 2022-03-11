package com.h2.robotmallservice.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * JWT生成工具类
 * header的格式（算法、token的类型）,默认：{"alg": "HS512","typ": "JWT"}
 * payload的格式 设置：（用户信息、创建时间、生成时间）
 * signature的生成算法：
 * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
 */
@Component
public class JWTUtils {

    //返回头部
    private static final String HEADER = "Authorization";
    //Bearer
    private static final String BEARER = "Bearer ";
    //密匙
    private static final String SECRET = "h2qwertyuiop1357924680";

    //过期时间,30分钟
    private static final long EXPIRETIME = 30 * 1000L * 60;
    //客户端保存token的key
    private static final String USER_LOGIN_TOKEN = "USER_LOGIN_TOKEN";


    /**
     * 生成token
     */
    public static String generateToken(String sub) {
        return BEARER + JWT.create()
                .withSubject(sub)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRETIME))
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 校验token
     */
    public static String validateToken(String token) throws Exception {
        try {
            return JWT.require(Algorithm.HMAC256(SECRET))
                    .build()
                    .verify(token.replace(BEARER,""))
                    .getSubject();
        }catch (TokenExpiredException e){
            throw new Exception("token已经过期");
        }catch (Exception e){
            throw new Exception("token校验失败");
        }
    }

    public static void main(String[] args) throws Exception {
        String tokenTest = JWTUtils.generateToken("AA");
        String vToken = JWTUtils.validateToken(tokenTest);
        System.out.println(tokenTest);
        System.out.println(vToken);
    }
}
