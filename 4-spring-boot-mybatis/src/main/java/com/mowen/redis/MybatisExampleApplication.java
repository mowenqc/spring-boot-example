package com.mowen.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@MapperScan("com.mowen.mybatis")
@SpringBootApplication
public class MybatisExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisExampleApplication.class, args);
    }
}
