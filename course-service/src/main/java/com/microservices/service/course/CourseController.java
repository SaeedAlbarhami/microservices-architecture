package com.microservices.service.course;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Api(value="courses", description = "courses data", tags=("courses"))
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(value="/courses",method = RequestMethod.GET)
    @ApiOperation(value="Get All Courses", notes="Gets all courses", nickname="getCourses")
    public List<Course> findAll(@RequestParam(name="courseNumber", required = false)String courseNumber){
        if(StringUtils.isNotEmpty(courseNumber)){
            return Collections.singletonList(this.courseRepository.findByCourseNumber(courseNumber));
        }
        return (List<Course>) this.courseRepository.findAll();
    }

    @RequestMapping(value="/courses/{id}", method = RequestMethod.GET)
    @ApiOperation(value="Get Course", notes="Gets a single course based on its unique id", nickname = "getCourse")
    public Course findOne(@PathVariable("id")long id){
        return this.courseRepository.findOne(id);
    }
}
