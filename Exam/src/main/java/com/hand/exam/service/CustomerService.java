package com.hand.exam.service;


import com.hand.exam.entity.Customer;

public interface CustomerService {
    Customer findByName(String firstName, String password);

    Short insert(Customer customer);

    int update(Customer customer);

    int delete(Customer customer);

    int findLastId();
}
