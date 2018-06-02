package com.microservices.service.booking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findByDate(Date date);
    List<Booking> findAll();
}
