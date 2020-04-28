package com.mowen.springboot.thymeleaf.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/****
 * @project: spring-boot-example
 * @author: mowen
 * @create-time: 2020/4/28 16:33 
 * @description: 模拟登录，只是为了演示thymeleaf,但是也得让页面好看一点是不是， 要对自己有要求
 *****/
@Controller
public class LoginController {


    /**
     * 登录，模拟的，假的
     * @param request
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request,  String username, String password){
        request.getSession().setAttribute("userName", username);
        request.getSession().setAttribute("password", password);
        return "ok";
    }

    @GetMapping("login")
    public String loginPage(){
        return "login";
    }
}
