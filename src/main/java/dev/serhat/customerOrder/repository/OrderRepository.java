package dev.serhat.customerOrder.repository;

import dev.serhat.customerOrder.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {


}
