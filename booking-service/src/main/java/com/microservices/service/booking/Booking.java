package com.microservices.service.booking;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="BOOKING")
public class Booking {
    @Id
    @Column(name="BOOKING_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="COURSE_ID")
    private long courseId;
    @Column(name="STUDENT_ID")
    private long studentId;
    @Column(name="BOOKING_DATE")
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
