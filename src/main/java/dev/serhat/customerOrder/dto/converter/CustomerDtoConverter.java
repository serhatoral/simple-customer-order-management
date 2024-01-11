package dev.serhat.customerOrder.dto.converter;

import dev.serhat.customerOrder.dto.CustomerDto;
import dev.serhat.customerOrder.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerDtoConverter {




    public  CustomerDto customerDtoFromCustomer(Optional<Customer> customer){
        return customer.map(c -> new CustomerDto(c.getId(),c.getName(),c.getUsername())).orElse(null);

    }
}
