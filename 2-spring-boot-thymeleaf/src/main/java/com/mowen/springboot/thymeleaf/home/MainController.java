package com.mowen.springboot.thymeleaf.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.expression.Lists;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/****
 * @project: spring-boot-example
 * @author: huangkai
 * @create-time: 2020/4/28 17:01 
 * @description:
 *****/
@Controller
public class MainController {

    @RequestMapping("welcome")
    public String welcome(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        try {
            Object userName = request.getSession().getAttribute("userName");
            if(userName == null){
                response.sendRedirect("/login");
                return null;
            }
            modelMap.put("userName", userName);
            modelMap.put("date", new Date());
            List<User> userList = Arrays.asList(new User("m", 1), new User("o", 3));
            modelMap.put("userList", userList);
            modelMap.put("author", null);
            modelMap.put("case", 1);
            modelMap.put("email", "");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "welcome";
    }


    public static class User{

        private String name;
        private int data;
        public User(String name, int data){
            this.name = name;
            this.data = data;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
