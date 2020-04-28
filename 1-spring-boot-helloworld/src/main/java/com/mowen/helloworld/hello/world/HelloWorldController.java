package com.mowen.helloworld.hello.world;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/****
 * @project: example
 * @author: mowen
 * @create-time: 2020/4/28 15:09 
 * @description:
 *****/
@RestController
public class HelloWorldController {

    @RequestMapping("helloworld")
    public String hello(){
        return "helloworld";
    }
}
