package com.mowen.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Administrator
 */
@MapperScan("com.mowen")
@ServletComponentScan(basePackages = {"com.mowen"})
@SpringBootApplication
public class RedisExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisExampleApplication.class, args);
    }
}
