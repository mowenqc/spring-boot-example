package com.mowen.swagger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@MapperScan("com.mowen")
@SpringBootApplication
public class SwaggerExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerExampleApplication.class, args);
    }
}
