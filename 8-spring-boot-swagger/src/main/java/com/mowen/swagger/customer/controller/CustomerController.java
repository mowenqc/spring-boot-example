package com.mowen.swagger.customer.controller;

import com.mowen.swagger.customer.domain.Customer;
import com.mowen.swagger.customer.service.ICustomerService;
import io.swagger.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @description: 顾客表
 * @author: Administrator
 * @createTime: 2020-04-29 11:40:45
 */
@Api("顾客注册登录管理")
@Controller
@RequestMapping("customer")
public class CustomerController {
    private Logger logger = LogManager.getLogger(getClass());

    @Resource
    private ICustomerService customerService;

    @RequestMapping("index")
    public String index() {
        return "login";
    }

    @ApiOperation("发起登录请求")
    @ApiImplicitParams({
            @ApiImplicitParam(name="username",value="用户名",dataType="string", required = true, paramType = "form",example="mowen"),
            @ApiImplicitParam(name="password",value="密码",dataType="string", paramType = "form",example="123456")})
    @PostMapping("login")
    @ResponseBody
    public String login(String username, String password, HttpServletRequest request) {
        try {
            if(username == null || username != ""){
                Customer customer = customerService.findCustomerByName(username);
                if(customer == null){
                    Customer customer1 = new Customer();
                    customer1.setName(username);
                    customer1.setPassword(password);
                    String remoteAddr = request.getRemoteAddr();
                    customer1.setIp(remoteAddr);
                    customer1.setStatus(1);
                    customerService.addCustomer(customer1);
                }
                request.getSession().setAttribute("username", username);
            }else {
                return "fail";
            }
            return "ok";
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return "fail";
        }
    }

    @RequestMapping("welcome")
    public String welcome(HttpServletRequest request, ModelMap modelMap){
        try {
            Object userName = request.getSession().getAttribute("username");
            if(userName == null){
                return "redirect:/customer/login";
            }
            Customer customer = customerService.findCustomerByName(userName.toString());
            modelMap.put("customer", customer);
            modelMap.put("date", new Date());
            return "welcome";
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return "error";
        }
    }

    /**
     * 新增Customer -> customer
     *
     * @param customer
     * @return
     */
    @RequestMapping("addCustomer.html")
    @ResponseBody
    public String addCustomer(Customer customer) {
        try {
            customerService.addCustomer(customer);
            return "ok";
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return e.getMessage();
        }
    }

    /**
     * 删除 Customer -> customer
     *
     * @return
     */
    @RequestMapping("deleteCustomerById.html")
    @ResponseBody
    public String deleteCustomerById(Customer customer) {
        try {
            customerService.deleteCustomerById(customer);
            return "ok";
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***
     * 修改 Customer -> customer
     * @param customer
     * @return
     */
    @RequestMapping("updateCustomer.html")
    @ResponseBody
    public String updateCustomer(Customer customer) {
        try {
            customerService.updateCustomer(customer);
            return "ok";
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return e.getMessage();
        }
    }

    /**
     * 根据ID查找
     *
     * @return
     */
    @RequestMapping("findCustomerById.html")
    @ResponseBody
    public String findCustomerById(Customer customer) {
        try {
            Customer resultcustomer = customerService.findCustomer(customer);
            return "ok";
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return e.getMessage();
        }
    }

    /**
     * 分页获取属性列表
     *
     * @return
     */
    @RequestMapping("listCustomer.html")
    @ResponseBody
    public String listCustomer(Customer customer, RowBounds rowBounds) {
        try {
            List<Customer> list = customerService.listCustomer(customer, rowBounds);
            int count = customerService.countCustomer(customer);
            return "ok";
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return e.getMessage();
        }
    }
}
