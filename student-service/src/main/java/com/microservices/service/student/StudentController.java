package com.microservices.service.student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping(value="/students")
@Api(value="students", description = "Data service operations on guests", tags=("guests"))
public class StudentController {

    @Autowired
    private StudentRepository guestRepository;

    @RequestMapping(method= RequestMethod.GET)
    @ApiOperation(value="Get All Students", notes="Gets all students in the system", nickname="getStudents")
    public List<Student> findAll(@RequestParam(name="emailAddress", required = false)String emailAddress){
        if(StringUtils.isNotBlank(emailAddress)){
            return Collections.singletonList(this.guestRepository.findByEmailAddress(emailAddress));
        }
        return (List<Student>) this.guestRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student findOne(@PathVariable(name="id")long id){
        return this.guestRepository.findOne(id);
    }
}
