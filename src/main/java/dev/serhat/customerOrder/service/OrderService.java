package dev.serhat.customerOrder.service;

import dev.serhat.customerOrder.dto.CreateOrderRequest;

import dev.serhat.customerOrder.dto.OrderDto;
import dev.serhat.customerOrder.dto.converter.OrderDtoConverter;
import dev.serhat.customerOrder.model.Customer;
import dev.serhat.customerOrder.model.Order;
import dev.serhat.customerOrder.model.OrderStatus;
import dev.serhat.customerOrder.model.OrderTransaction;
import dev.serhat.customerOrder.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Optional;


@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final OrderDtoConverter orderDtoConverter;

    public OrderService(OrderRepository orderRepository, CustomerService customerService, OrderDtoConverter orderDtoConverter) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.orderDtoConverter = orderDtoConverter;
    }

    public OrderDto findById(String s) {
        return null;
    }


    public OrderDto create(CreateOrderRequest createOrderRequest) {

        Customer customer = customerService.findById(createOrderRequest.getCustomerId());

        Order order = new Order("", Calendar.getInstance(), createOrderRequest.getProduct(),createOrderRequest.getAmount(), customer);
        OrderTransaction orderTransaction = new OrderTransaction("", OrderStatus.ORDER_RECEIVED, createOrderRequest.getProduct(), order);


        order.getOrderTransactions().add(orderTransaction);

        return orderDtoConverter.orderDtoFromOrder(Optional.of(orderRepository.save(order)));
    }
}
