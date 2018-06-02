package com.microservices.api.gateway.client;

import com.microservices.api.gateway.domain.Student;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
public class StudentServiceFallbakImpl implements StudentService {
    @Override
    public List<Student> findAll(String emailAddress) {
        return Collections.emptyList();
    }

    @Override
    public Student findOne(long id) {
        Student student = new Student();
            student.setFirstName("Course");
            student.setLastName("Booked");
            return student;
    }
}
