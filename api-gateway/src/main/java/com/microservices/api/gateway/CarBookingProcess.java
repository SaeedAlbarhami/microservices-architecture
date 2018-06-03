package com.microservices.api.gateway;

import com.microservices.api.gateway.client.BookingService;
import com.microservices.api.gateway.client.CarService;
import com.microservices.api.gateway.client.CustomerService;
import com.microservices.api.gateway.domain.Booking;
import com.microservices.api.gateway.domain.Car;
import com.microservices.api.gateway.domain.CustomerCarBooking;
import com.microservices.api.gateway.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarBookingProcess {
    private CustomerService customerService;
    private CarService carService;
    private BookingService bookingService;

    @Autowired
    public CarBookingProcess(CustomerService customerService,
                             CarService carService,
                             BookingService bookingService) {
        this.customerService = customerService;
        this.carService = carService;
        this.bookingService = bookingService;
    }


    public List<CustomerCarBooking> getCarBookingsForDate(String dateString){
        List<Car> cars = this.carService.findAll(null);
        Map<Long, CustomerCarBooking> carBookingMap = new HashMap<>();
        cars.forEach(car ->{
            CustomerCarBooking customerCarBooking = new CustomerCarBooking();
            customerCarBooking.setCarId(car.getId());
            customerCarBooking.setCarName(car.getName());
            customerCarBooking.setCarNumber(car.getCarNumber());
            carBookingMap.put(car.getId(), customerCarBooking);
        });
        Iterable<Booking> bookings = this.bookingService.findAll(dateString);
        if(null!=bookings){
            bookings.forEach(booking -> {
                Customer customer = this.customerService.findOne(booking.getCustomerId());
                if(null!= customer) {
                    CustomerCarBooking customerCarBooking = carBookingMap.get(booking.getCarId());
                    customerCarBooking.setDate(booking.getDate());
                    customerCarBooking.setFirstName(customer.getFirstName());
                    customerCarBooking.setLastName(customer.getLastName());
                    customerCarBooking.setCustomerId(customer.getId());
                }
            });
        }
        List<CustomerCarBooking> customerCarBookings = new ArrayList<>();
        for(Long carId:carBookingMap.keySet()){
            customerCarBookings.add(carBookingMap.get(carId));
        }
        return customerCarBookings;
    }
}
