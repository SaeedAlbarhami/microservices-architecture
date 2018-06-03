package com.microservices.service.car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends CrudRepository<Car, Long>{
    Car findByCarNumber(String carNumber);
}
