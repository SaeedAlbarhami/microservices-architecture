package com.microservices.app.school.client;

import com.microservices.app.school.domain.StudentCourseBooking;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient("APIGATEWAY")
public interface StudentCourseBookingService {

    @RequestMapping(value = "/coursebookings", method = RequestMethod.GET)
     List<StudentCourseBooking> getCourseBookings(@RequestParam(name = "date",required = false) String date);

}
