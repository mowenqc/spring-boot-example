package com.mowen.filter.customer.service.impl;

import com.mowen.filter.customer.dao.CustomerMapper;
import com.mowen.filter.customer.domain.Customer;
import com.mowen.filter.customer.service.ICustomerService;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 顾客表
 * @author: Administrator
 * @createTime: 2020-04-29 11:40:45
 */

@Service
public class CustomerService implements ICustomerService {
    @Resource
    private CustomerMapper customerMapper;

    /**
     * 新增
     *
     * @param customer
     * @return
     */
    @Override
    public int addCustomer(Customer customer) {
        return customerMapper.addCustomer(customer);
    }

    /**
     * 删除
     *
     * @param customer
     * @return
     */
    @Override
    public void deleteCustomerById(Customer customer) {
        customerMapper.deleteCustomer(customer);
    }

    /***
     * 修改
     * @param customer
     * @return
     */
    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    /**
     * 根据ID查找
     *
     * @param customer
     * @return
     */
    @Override
    public Customer findCustomer(Customer customer) {
        return customerMapper.findCustomer(customer);
    }

    /***
     * 分页查找
     * @param row
     * @return
     */
    @Override
    public List<Customer> listCustomer(Customer customer, RowBounds row) {
        return customerMapper.listCustomer(customer, row);
    }

    /***
     * count总数
     * @return
     */
    @Override
    public int countCustomer(Customer customer) {
        return customerMapper.countCustomer(customer);
    }

    @Override
    public Customer findCustomerByName(String name) {
        return customerMapper.findCustomerByName(name);
    }
}
