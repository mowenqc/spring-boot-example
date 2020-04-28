package com.mowen.springboot.thymeleaf.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
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
            modelMap.put("count", new Random(10).nextInt());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "welcome";
    }
}
