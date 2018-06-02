package com.microservices.api.gateway;

import com.microservices.api.gateway.client.BookingService;
import com.microservices.api.gateway.client.StudentService;
import com.microservices.api.gateway.client.CourseService;
import com.microservices.api.gateway.domain.Booking;
import com.microservices.api.gateway.domain.Course;
import com.microservices.api.gateway.domain.Student;
import com.microservices.api.gateway.domain.StudentCourseBooking;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="StudentCourseBooking", description = "Show course bookings", tags=("courseBooking"))
public class CourseBookingController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentCourseBookingProcess studentCourseBookingProcess;

    @RequestMapping(value = "/coursebookings", method = RequestMethod.GET)
    public List<StudentCourseBooking> getCourseBookings(@RequestParam(name = "date",required = false) String date){
        return this.studentCourseBookingProcess.getCourseBookingsForDate(date);
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    @ApiOperation(value="Get All Courses", notes="Gets all courses in", nickname="getCourses")
    public List<Course> getAllCourses(@RequestParam(name="courseNumber", required=false)String courseNumber){
        return this.courseService.findAll(courseNumber);
    }

    @RequestMapping(value="/bookings", method=RequestMethod.GET)
    @ApiOperation(value="Get Course Bookings", notes="Get course bookings", nickname="getCourseBookingInDate")
    public List<Booking> getCourseBookingForDate(@RequestParam(name = "date",required = false) String date){
        return this.bookingService.findAll(date);
    }

    @RequestMapping(value ="/students", method= RequestMethod.GET)
    @ApiOperation(value="get students", notes="get all students", nickname="getStudents")
    public List<Student> findAll(@RequestParam(name="emailAddress", required = false)String emailAddress){
        return this.studentService.findAll(emailAddress);
    }
}
