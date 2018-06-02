package com.microservices.api.gateway.client;

import com.microservices.api.gateway.domain.Booking;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
public class BookingServiceFallbakImpl implements BookingService {

    @Override
    public List<Booking> findAll(String date) {
        return Collections.emptyList();
    }
}
