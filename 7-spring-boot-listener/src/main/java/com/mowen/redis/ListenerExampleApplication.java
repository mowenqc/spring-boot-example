package com.mowen.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Administrator
 */
@MapperScan("com.mowen")
@SpringBootApplication
@ServletComponentScan
public class ListenerExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ListenerExampleApplication.class, args);
    }
}
