package com.microservices.api.gateway.client;

import com.microservices.api.gateway.domain.Booking;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "BOOKINGSERVICE",fallback = BookingServiceFallbakImpl.class)
public interface BookingService {
    @RequestMapping(value = "/bookings", method = RequestMethod.GET)
    List<Booking> findAll(@RequestParam(name = "date", required = false) String date);
}