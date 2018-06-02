package com.microservices.api.gateway.client;

import com.microservices.api.gateway.domain.Course;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
public class CourseServiceFallbakImpl implements CourseService {
    @Override
    public List<Course> findAll(String courseNumber) {
        return Collections.emptyList();
    }

    @Override
    public Course findOne(long id) {
       Course course =new Course();
       course.setId(500);
       course.setName("Default course");
       course.setCourseNumber("5800");
       return course;
    }
}
