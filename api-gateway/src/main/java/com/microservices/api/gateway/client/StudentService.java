package com.microservices.api.gateway.client;

import com.microservices.api.gateway.domain.Student;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "STUDENTSERVICE",fallback = StudentServiceFallbakImpl.class)
public interface StudentService {


    @RequestMapping(value = "/students",method= RequestMethod.GET)
    List<Student> findAll(@RequestParam(name="emailAddress", required = false)String emailAddress);

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    Student findOne(@PathVariable(name="id")long id);
}
