package com.microservices.app.rental.car;

import com.microservices.app.rental.car.client.CarBookingService;
import com.microservices.app.rental.car.domain.CarBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class CarRentalAppController {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final CarBookingService carBookingService;

    @Autowired
    public CarRentalAppController(CarBookingService carBookingService){
        super();
        this.carBookingService = carBookingService;
    }

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String getBookings(@RequestParam(value="date", required=false)String dateString, Model model){
        List<CarBooking> carBookings = this.carBookingService.getCarBookings(dateString);
        model.addAttribute("carBookings", carBookings);
        return "booking";
    }

}