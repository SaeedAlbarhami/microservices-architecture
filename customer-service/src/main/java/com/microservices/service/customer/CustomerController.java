package com.microservices.service.customer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping(value="/customers")
@Api(value="customers", description = "Data service for customers", tags=("customers"))
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method= RequestMethod.GET)
    @ApiOperation(value="Get All Customers", notes="Gets all customers in the system", nickname="getCustomers")
    public List<Customer> findAll(@RequestParam(name="emailAddress", required = false)String emailAddress){
        if(StringUtils.isNotBlank(emailAddress)){
            return Collections.singletonList(this.customerRepository.findByEmailAddress(emailAddress));
        }
        return (List<Customer>) this.customerRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer findOne(@PathVariable(name="id")long id){
        return this.customerRepository.findOne(id);
    }
}
