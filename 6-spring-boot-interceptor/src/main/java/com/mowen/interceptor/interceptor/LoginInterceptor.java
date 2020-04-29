package com.mowen.interceptor.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/****
 * @project: spring-boot-example
 * @author: mowenqc
 * @create-time: 2020/4/29 15:34 
 * @description:
 *****/
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = LogManager.getLogger(getClass());

    public LoginInterceptor(){
        logger.info("初始化拦截器");
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        logger.info(requestURI);
        Object username = request.getSession().getAttribute("username");
        logger.info("username = " + username);
        if(username == null){
            response.sendRedirect("/customer/index");
            return false;
        }
        else {
            return true;
        }
    }
}
