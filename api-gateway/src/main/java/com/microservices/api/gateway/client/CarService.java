package com.microservices.api.gateway.client;

import com.microservices.api.gateway.domain.Car;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value="CARSERVICE",fallback = CarServiceFallbakImpl.class)
public interface CarService {

    @RequestMapping(value="/cars", method= RequestMethod.GET)
    List<Car> getAllCars(@RequestParam(name="carNumber", required=false)String carNumber);

    @RequestMapping(value="/cars/{id}", method = RequestMethod.GET)
    Car getCar(@PathVariable("id")long id);
}
