package com.mowen.filter.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/****
 * @project: spring-boot-example
 * @author: mowen
 * @create-time: 2020/4/29 14:08 
 * @description:
 *****/
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

    private Logger logger = LogManager.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init Login filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = httpServletRequest.getRequestURI();
        logger.info("访问地址：" + requestURI);
        Object username = httpServletRequest.getSession().getAttribute("username");
        logger.info("username = " + username);
        if(username != null || requestURI.contains("/customer/index") || requestURI.contains("layui") || requestURI.contains("/customer/login") ){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            response.sendRedirect("/customer/index");
        }
    }

    @Override
    public void destroy() {

    }
}
