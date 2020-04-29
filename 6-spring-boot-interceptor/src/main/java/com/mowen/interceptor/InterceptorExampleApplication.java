package com.mowen.interceptor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Administrator
 */
@MapperScan("com.mowen")
@SpringBootApplication
public class InterceptorExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(InterceptorExampleApplication.class, args);
    }
}
