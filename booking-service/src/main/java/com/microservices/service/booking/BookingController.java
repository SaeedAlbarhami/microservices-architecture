package com.microservices.service.booking;

import com.microservices.service.booking.utils.Utils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/bookings")
@Api(value="bookings", description = "Data service operations on bookings", tags=("bookings"))
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private Utils dateTimeUtils;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Get All booking", notes="Gets all booking", nickname="getBooking")
    public List<Booking> getAllBookings(@RequestParam(name="date", required=false)String date){
         if(StringUtils.isNotBlank(date)){
            return this.bookingRepository.findByDate(this.dateTimeUtils.createDateFromDateString(date));
        }else{
            return this.bookingRepository.findAll();
        }
    }
}
