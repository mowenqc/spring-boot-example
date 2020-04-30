package com.mowen.activemq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author Administrator
 */
@EnableJms
@MapperScan("com.mowen")
@ServletComponentScan(basePackages = {"com.mowen"})
@SpringBootApplication
public class ActivemqExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActivemqExampleApplication.class, args);
    }
}
