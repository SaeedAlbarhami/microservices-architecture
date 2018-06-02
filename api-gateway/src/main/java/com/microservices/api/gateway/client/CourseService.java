package com.microservices.api.gateway.client;

import com.microservices.api.gateway.domain.Course;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value="COURSESERVICE",fallback = CourseServiceFallbakImpl.class)
public interface CourseService {

    @RequestMapping(value="/courses", method= RequestMethod.GET)
    List<Course> findAll(@RequestParam(name="courseNumber", required=false)String courseNumber);

    @RequestMapping(value="/courses/{id}", method = RequestMethod.GET)
    Course findOne(@PathVariable("id")long id);
}
