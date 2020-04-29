package com.mowen.filter.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/****
 * @project: spring-boot-example
 * @author: huangkai
 * @create-time: 2020/4/29 16:51 
 * @description:
 *****/
@WebListener
public class SystemListener implements ServletContextListener {

    private Logger logger = LogManager.getLogger(getClass());
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("this servlet context has been init");
    }
}
