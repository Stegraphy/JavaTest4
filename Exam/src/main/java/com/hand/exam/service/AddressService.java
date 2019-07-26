package com.hand.exam.service;


import com.hand.exam.entity.Address;

public interface AddressService {

    Address findByAddress(String address);
}
