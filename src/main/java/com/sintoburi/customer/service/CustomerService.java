package com.sintoburi.customer.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seongnamfc
 * @package com.sintoburi.customer.service
 * @file CustomerService
 * @description
 * @date 2021/12/18
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerService {

    @GetMapping(value = "/test")
    public String test() {
        return "hi";
    }

}
