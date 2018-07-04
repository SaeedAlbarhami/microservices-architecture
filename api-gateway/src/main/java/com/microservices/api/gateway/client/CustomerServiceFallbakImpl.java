package com.microservices.api.gateway.client;

import com.microservices.api.gateway.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
public class CustomerServiceFallbakImpl implements CustomerService {

    @Override
    public List<Customer> getAllCustomers(String emailAddress) {
        return Collections.emptyList();
    }

    @Override
    public Customer getCustomer(long id) {
        Customer customer = new Customer();
            customer.setFirstName("Customer");
            customer.setLastName("Booked By");
            return customer;
    }
}
