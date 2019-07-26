package com.hand.exam.service.impl;

import com.hand.exam.entity.Address;
import com.hand.exam.mapper.AddressMapper;
import com.hand.exam.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Address findByAddress(String address) {
        Address record = new Address();
        record.setAddress(address);
        return addressMapper.selectOne(record);
    }
}
