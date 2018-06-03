package com.microservices.api.gateway.client;

import com.microservices.api.gateway.domain.Customer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "CUSTOMERSERVICE",fallback = CustomerServiceFallbakImpl.class)
public interface CustomerService {


    @RequestMapping(value = "/customers",method= RequestMethod.GET)
    List<Customer> findAll(@RequestParam(name="emailAddress", required = false)String emailAddress);

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    Customer findOne(@PathVariable(name="id")long id);
}
