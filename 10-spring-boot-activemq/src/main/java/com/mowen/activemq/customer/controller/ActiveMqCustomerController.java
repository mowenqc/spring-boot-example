package com.mowen.activemq.customer.controller;

import com.mowen.common.controller.BaseController;
import com.mowen.common.util.StringUtil;
import com.mowen.activemq.customer.domain.Customer;
import com.mowen.activemq.customer.service.ICustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.MessagingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/****
 * @project: spring-boot-example
 * @author: huangkai
 * @create-time: 2020/4/30 15:08 
 * @description:
 *****/
@RestController
@RequestMapping("customer/activemq")
public class ActiveMqCustomerController extends BaseController {

    private Logger logger = LogManager.getLogger(getClass());

    @Resource
    private ICustomerService customerService;

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @GetMapping("send")
    public String sendCustomer(String name){
        try {
            if(StringUtil.isEmpty(name)){
                return buildErrorResultMessage("用户名不能为空");
            }
            Customer customer = customerService.findCustomerByName(name);
            if(customer == null){
                return buildErrorResultMessage("customer 的name = " + name + "不存在");
            }
            jmsMessagingTemplate.convertAndSend("customer", StringUtil.toJson(customer));
            return buildSuccessResult(customer);
        } catch (MessagingException e) {
            logger.error(e.getMessage(), e);
            return buildErrorResultMessage("服务获取数据失败");
        }
    }


    @JmsListener(destination = "customer")
    public void receiveMessage(String text){
        logger.info("接收到消息：" + text);
        Customer customer = StringUtil.toObject(text, Customer.class);
        System.out.println(customer);
        Customer serviceCustomerByName = customerService.findCustomerByName(customer.getName());
        logger.info(serviceCustomerByName);
    }
}
