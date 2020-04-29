package com.mowen.filter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Administrator
 */
@MapperScan("com.mowen.filter")
@ServletComponentScan(basePackages = {"com.mowen.filter.filter"})
@SpringBootApplication
public class FilterExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilterExampleApplication.class, args);
    }
}
