package com.h2.robotmallservice.interceptor;

import com.auth0.jwt.JWT;
import com.h2.robotmallservice.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //从header中提取token
        String token = request.getHeader("Authorization");
        // token不存在
        if (token == null || token.equals("")) {
            throw new Exception("请登录");
        }
        //校验token
        String sub = JWTUtils.validateToken(token);
        if (sub == null || sub.equals("")) {
            throw new Exception("校验失败");
        }
        return true;
    }
}
