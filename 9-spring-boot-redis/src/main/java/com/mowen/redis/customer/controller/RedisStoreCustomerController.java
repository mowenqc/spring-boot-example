package com.mowen.redis.customer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mowen.common.controller.BaseController;
import com.mowen.common.domain.ResponseEntity;
import com.mowen.common.util.StringUtil;
import com.mowen.redis.customer.domain.Customer;
import com.mowen.redis.customer.service.ICustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/****
 * @project: spring-boot-example
 * @author: mowen
 * @create-time: 2020/4/29 17:36 
 * @description:
 *****/
@RestController
@RequestMapping("customer/redis")
public class RedisStoreCustomerController extends BaseController {

    private Logger logger = LogManager.getLogger(getClass());

    @Resource
    private ICustomerService customerService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping("save")
    public String saveCustomerToRedis(String name) {
        try {
            Customer customer = customerService.findCustomerByName(name);
            if (customer == null) {
                return buildErrorResultMessage("数据不存在");
            }
            String json = StringUtil.toJson(customer);
            stringRedisTemplate.opsForValue().set(customer.getName(), json);
            return buildSuccessResult(customer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
           return buildErrorResultMessage("服务异常，请稍后重试");
        }
    }

    /**
     * 获取是数据
     * @param name
     * @return
     */
    @GetMapping("getData")
    public String getCustomer(String name) {
        try {
            String s = stringRedisTemplate.opsForValue().get(name);
            if (StringUtil.isNotEmpty(s)) {
                logger.info("从redis中获取数据返回");
                return buildSuccessResult(s);
            }
            Customer customer = customerService.findCustomerByName(name);
            if(customer != null){
                logger.info("从数据库中获取数据返回");
                return buildSuccessResult(customer);
            }
            return buildErrorResultMessage("数据不存在，请确定name=" + name);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return buildErrorResultMessage(e.getMessage());
        }
    }
}
