package com.mowen.swagger.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//让Spring来加载该类配置
@Configuration
//是否禁用swagger 的配置
@ConditionalOnProperty(prefix = "swagger",value = {"enable"},havingValue = "true")
@EnableSwagger2 //启用Swagger2
public class SwaggerConfig {
	 @Bean
	    public Docket alipayApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .groupName("I接口文档")
	                .apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.mowen")).build();
	    }
	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .version("1.0.0")
	                .build();
	    }
}
