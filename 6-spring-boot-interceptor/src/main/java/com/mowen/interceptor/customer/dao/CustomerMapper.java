package com.mowen.interceptor.customer.dao;


import com.mowen.interceptor.customer.domain.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @description: 顾客表
 * @author: Administrator
 * @createTime: 2020-04-29 11:40:45
 */
@Repository
@Mapper
public interface CustomerMapper {

    /**
     * 新增customer -> customer
     *
     * @param customer
     * @return
     */
    int addCustomer(Customer customer);

    /**
     * 删除customer
     *
     * @param customer 对象中包含Id
     * @return
     */
    void deleteCustomer(Customer customer);

    /***
     * 修改customer -> customer
     * @param customer
     * @return
     */
    void updateCustomer(Customer customer);

    /**
     * 根据ID查找
     *
     * @param customer
     * @return customer
     */
    Customer findCustomer(Customer customer);

    /***
     * 分页查找
     * @param page
     * @param customer 参数数据
     * @return customer list
     */
    List<Customer> listCustomer(@Param("obj") Customer customer, @Param("page") RowBounds page);

    /***
     * count总数
     *
     * @return
     */
    int countCustomer(Customer customer);


    /**
     * 根据名字获取顾客
     * @param name
     * @return
     */
    Customer findCustomerByName(String name);
}
