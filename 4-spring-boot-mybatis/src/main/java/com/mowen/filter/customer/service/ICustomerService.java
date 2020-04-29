package com.mowen.filter.customer.service;

import org.apache.ibatis.session.RowBounds;
import com.mowen.filter.customer.domain.Customer;

import java.util.List;

/**
* @description: 顾客表
* @author: Administrator
* @createTime: 2020-04-29 11:40:45
*/
public interface ICustomerService {

    /**
    * 新增
    * @param customer
    * @return
    */
    int addCustomer(Customer customer);

    /**
    * 删除
    * @param customer 对象中包含Id
    * @return
    */
    void deleteCustomerById(Customer customer);

    /***
    * 修改
    * @param customer
    * @return
    */
    void updateCustomer(Customer customer);

    /**
    * 根据ID查找
    * @param customer
    * @return
    */
    Customer findCustomer(Customer customer);

    /***
    * 分页查找
    * @param page
    * @param customer 参数数据
    * @return customer list
    */
    List<Customer> listCustomer(Customer customer, RowBounds page);

    /***
    * count总数
    * @return
    */
    int countCustomer(Customer customer);

    /**
     * 根据名字获取用户信息
     * @param name
     * @return
     */
    Customer findCustomerByName(String name);

}
