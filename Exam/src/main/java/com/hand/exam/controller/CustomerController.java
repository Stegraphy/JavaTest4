package com.hand.exam.controller;

import ch.qos.logback.classic.Logger;

import com.hand.exam.entity.Address;
import com.hand.exam.entity.Customer;
import com.hand.exam.entity.CustomerEVO;
import com.hand.exam.service.AddressService;
import com.hand.exam.service.CustomerService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
public class CustomerController {
    private Logger logger = (Logger) LoggerFactory.getLogger(FilmController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @PutMapping("/customer")
    public int create(@RequestBody CustomerEVO customerEVO, HttpServletResponse response) {
        logger.info(">>>>>>>>>>>>>>>insert customer<<<<<<<<<<<<<<<<<<<<<< ");
        Address address = addressService.findByAddress(customerEVO.getAddress());
        Customer customer = new Customer();
        customer.setFirstName(customerEVO.getFirst_name());
        customer.setLastName(customerEVO.getLast_name());
        customer.setEmail(customerEVO.getEmail());
        customer.setAddressId(address.getAddressId());
        customer.setStoreId((byte) 1);
        customer.setCreateDate(new Date());
        Short result = customerService.insert(customer);

        Short customerId = result;
        logger.info("insert customerId is"+result);
        Cookie cookie = new Cookie("customerId",String.valueOf(customerId));
        response.addCookie(cookie);
        return result;
    }

    @PostMapping("/customer/{id}")
    public int update(@RequestBody CustomerEVO customerEVO, @PathVariable("id") Short id) {
        Short customerId = id;
        logger.info(">>>>>>>>>>>>>>>>update customer with customerId is "+customerId);
        Address address = addressService.findByAddress(customerEVO.getAddress());
        Customer customer = new Customer();
        customer.setCustomerId((short) 600);
        customer.setFirstName(customerEVO.getFirst_name());
        customer.setLastName(customerEVO.getLast_name());
        customer.setEmail(customerEVO.getEmail());
        customer.setAddressId(address.getAddressId());
        customer.setStoreId((byte) 1);
        customer.setCreateDate(new Date());
        int result = customerService.update(customer);
        return result;
    }

    @DeleteMapping("/customer/{id}")
    public int delete(@PathVariable("id") Short id,HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Cookie cookie = cookies[0];
        Short cId = Short.parseShort(cookie.getValue());
        System.out.println(cId);
        Short customerId = cId;
        logger.info(">>>>>>>>>>>>>>>>>>>>Delete customer with customerId is "+customerId);
       Customer customer = new Customer();
       customer.setCustomerId(customerId);
        return customerService.delete(customer);
    }
}
