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
    @Column(name="CAR_ID")
    private long carId;
    @Column(name="CUSTOMER_ID")
    private long customerId;
    @Column(name="BOOKING_DATE")
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
