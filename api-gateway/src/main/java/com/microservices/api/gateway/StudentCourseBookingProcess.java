package com.microservices.api.gateway;

import com.microservices.api.gateway.client.BookingService;
import com.microservices.api.gateway.client.CourseService;
import com.microservices.api.gateway.client.StudentService;
import com.microservices.api.gateway.domain.Booking;
import com.microservices.api.gateway.domain.Course;
import com.microservices.api.gateway.domain.StudentCourseBooking;
import com.microservices.api.gateway.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentCourseBookingProcess {
    private StudentService studentService;
    private CourseService courseService;
    private BookingService bookingService;

    @Autowired
    public StudentCourseBookingProcess(StudentService studentService,
                                       CourseService courseService,
                                       BookingService bookingService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.bookingService = bookingService;
    }


    public List<StudentCourseBooking> getCourseBookingsForDate(String dateString){
        List<Course> courses = this.courseService.findAll(null);
        Map<Long, StudentCourseBooking> courseBookingMap = new HashMap<>();
        courses.forEach(course->{
            StudentCourseBooking studentCourseBooking = new StudentCourseBooking();
            studentCourseBooking.setCourseId(course.getId());
            studentCourseBooking.setCourseName(course.getName());
            studentCourseBooking.setCourseNumber(course.getCourseNumber());
            courseBookingMap.put(course.getId(), studentCourseBooking);
        });
        Iterable<Booking> bookings = this.bookingService.findAll(dateString);
        if(null!=bookings){
            bookings.forEach(booking -> {
                Student student = this.studentService.findOne(booking.getStudentId());
                if(null!=student) {
                    StudentCourseBooking studentCourseBooking = courseBookingMap.get(booking.getCourseId());
                    studentCourseBooking.setDate(booking.getDate());
                    studentCourseBooking.setFirstName(student.getFirstName());
                    studentCourseBooking.setLastName(student.getLastName());
                    studentCourseBooking.setStudentId(student.getId());
                }
            });
        }
        List<StudentCourseBooking> studentCourseBookings = new ArrayList<>();
        for(Long courseId:courseBookingMap.keySet()){
            studentCourseBookings.add(courseBookingMap.get(courseId));
        }
        return studentCourseBookings;
    }
}
