package com.microservices.service.course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
    Course findByCourseNumber(String courseNumber);
}