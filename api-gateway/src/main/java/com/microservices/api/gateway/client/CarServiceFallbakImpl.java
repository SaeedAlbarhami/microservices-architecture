package com.microservices.api.gateway.client;

import com.microservices.api.gateway.domain.Car;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
public class CarServiceFallbakImpl implements CarService {
    @Override
    public List<Car> findAll(String carNumber) {
        return Collections.emptyList();
    }

    @Override
    public Car findOne(long id) {
       Car car =new Car();
       car.setId(500);
       car.setName("Default car");
       car.setCarNumber("5800");
       return car;
    }
}
