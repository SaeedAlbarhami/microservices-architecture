package com.microservices.api.gateway;

import com.microservices.api.gateway.client.BookingService;
import com.microservices.api.gateway.client.CustomerService;
import com.microservices.api.gateway.client.CarService;
import com.microservices.api.gateway.domain.Booking;
import com.microservices.api.gateway.domain.Car;
import com.microservices.api.gateway.domain.Customer;
import com.microservices.api.gateway.domain.CustomerCarBooking;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="CustomerCarBooking", description = "Show car bookings", tags=("carBooking"))
public class CarBookingController {
    @Autowired
    private CarService carService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CarBookingProcess carBookingProcess;
    @RequestMapping(value = "/carbookings", method = RequestMethod.GET)
    public List<CustomerCarBooking> getCarBookings(@RequestParam(name = "date",required = false) String date){
        return this.carBookingProcess.getCarBookingsForDate(date);
    }


    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    @ApiOperation(value="Get All Cars", notes="Gets all cars in", nickname="getCars")
    public List<Car> getAllCars(@RequestParam(name="carNumber", required=false)String carNumber){
        return this.carService.getAllCars(carNumber);
    }

    @RequestMapping(value="/bookings", method=RequestMethod.GET)
    @ApiOperation(value="Get Car Bookings", notes="Get car bookings", nickname="getCarBookingInDate")
    public List<Booking> getCarBookingForDate(@RequestParam(name = "date",required = false) String date){
        return this.bookingService.getAllBookings(date);
    }

    @RequestMapping(value ="/customers", method= RequestMethod.GET)
    @ApiOperation(value="get customers", notes="get all customers", nickname="getCustomers")
    public List<Customer> getAllCustomers(@RequestParam(name="emailAddress", required = false)String emailAddress){
        return this.customerService.getAllCustomers(emailAddress);
    }
}
