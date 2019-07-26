package com.hand.exam.service.impl;


import com.hand.exam.entity.Customer;
import com.hand.exam.mapper.CustomerMapper;
import com.hand.exam.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer findByName(String firstName, String password) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(password);
        return  customerMapper.selectOne(customer);
    }

    @Override
    public Short insert(Customer customer) {
         customerMapper.insertSelective(customer);
        customerMapper.selectByPrimaryKey(customer);
        return customer.getCustomerId();
    }

    @Override
    public int update(Customer customer) {
        return customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public int delete(Customer customer) {
        return customerMapper.deleteByPrimaryKey(customer);
    }

    @Override
    public int findLastId() {
        return 0;
    }
}
