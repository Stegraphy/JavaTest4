package com.hand.exam.mapper;

import com.hand.exam.entity.Customer;
import tk.mybatis.mapper.common.Mapper;

public interface CustomerMapper extends Mapper<Customer> {
    Customer findByName(String FirstName);
}
