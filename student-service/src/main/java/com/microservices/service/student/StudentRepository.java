package com.microservices.service.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
    Student findByEmailAddress(String emailAddress);
}
