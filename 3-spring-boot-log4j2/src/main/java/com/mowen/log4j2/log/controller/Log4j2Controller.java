package com.mowen.log4j2.log.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/****
 * @project: spring-boot-example
 * @author: huangkai
 * @create-time: 2020/4/29 9:38 
 * @description:
 *****/
@Controller
@RequestMapping("log4j2")
public class Log4j2Controller {

    Logger logger = LogManager.getLogger(getClass());
    @RequestMapping("show")
    @ResponseBody
    public String showLog(){
        logger.info("info log");
        logger.error("error log");
        logger.debug("debug log");
        return "log4j2 OK!";
    }


}
