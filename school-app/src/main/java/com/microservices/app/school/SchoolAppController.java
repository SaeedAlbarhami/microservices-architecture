package com.microservices.app.school;

import com.microservices.app.school.client.StudentCourseBookingService;
import com.microservices.app.school.domain.StudentCourseBooking;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class SchoolAppController {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final StudentCourseBookingService studentCourseBookingService;

    @Autowired
    public SchoolAppController(StudentCourseBookingService studentCourseBookingService){
        super();
        this.studentCourseBookingService = studentCourseBookingService;
    }

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String getBookings(@RequestParam(value="date", required=false)String dateString, Model model){
        List<StudentCourseBooking> studentCourseBookings = this.studentCourseBookingService.getCourseBookings(dateString);
        model.addAttribute("studentCourseBookings", studentCourseBookings);
        return "booking";
    }

}