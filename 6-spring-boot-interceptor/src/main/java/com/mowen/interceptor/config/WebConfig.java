package com.mowen.interceptor.config;

import com.mowen.interceptor.interceptor.LoginInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/****
 * @project: spring-boot-example
 * @author: huangkai
 * @create-time: 2020/4/29 16:14 
 * @description:
 *****/
@SpringBootConfiguration
public class WebConfig implements WebMvcConfigurer {

    private Logger logger = LogManager.getLogger(getClass());

    public WebConfig() {
        logger.info("初始化webconfig");
    }
    @Resource
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/customer/index").excludePathPatterns("/customer/login").
                excludePathPatterns("/layui/**");
    }



}
