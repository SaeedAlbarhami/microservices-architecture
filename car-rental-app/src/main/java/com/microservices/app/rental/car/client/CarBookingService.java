package com.microservices.app.rental.car.client;

import com.microservices.app.rental.car.domain.CarBooking;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient("APIGATEWAY")
public interface CarBookingService {

    @RequestMapping(value = "/carbookings", method = RequestMethod.GET)
     List<CarBooking> getCarBookings(@RequestParam(name = "date",required = false) String date);

}
