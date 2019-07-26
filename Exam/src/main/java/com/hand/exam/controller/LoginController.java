package com.hand.exam.controller;

import ch.qos.logback.classic.Logger;
import com.hand.exam.entity.Customer;
import com.hand.exam.entity.LoginE;
import com.hand.exam.service.CustomerService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private Logger logger = (Logger) LoggerFactory.getLogger(FilmController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public String login(@RequestBody LoginE loginE){
        logger.info("login………………");
        String responseText = "login false";
        Customer customer = customerService.findByName(loginE.getLast_name(),loginE.getPassword());
        if (customer != null) {
            responseText = "login success";
            logger.info("login success");
        }
        return responseText;
    }
}
