package com.microservices.service.car;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Api(value="car", description = "cars data", tags=("car"))
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @RequestMapping(value="/cars",method = RequestMethod.GET)
    @ApiOperation(value="Get All Cars", notes="Gets all cars", nickname="getCars")
    public List<Car> findAll(@RequestParam(name="carNumber", required = false)String carNumber){
        if(StringUtils.isNotEmpty(carNumber)){
            return Collections.singletonList(this.carRepository.findByCarNumber(carNumber));
        }
        return (List<Car>) this.carRepository.findAll();
    }

    @RequestMapping(value="/cars/{id}", method = RequestMethod.GET)
    @ApiOperation(value="Get Car", notes="Gets a single car based on its unique id", nickname = "getCar")
    public Car findOne(@PathVariable("id")long id){
        return this.carRepository.findOne(id);
    }
}
