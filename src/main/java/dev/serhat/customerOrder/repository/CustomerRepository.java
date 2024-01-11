package dev.serhat.customerOrder.repository;

import dev.serhat.customerOrder.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
