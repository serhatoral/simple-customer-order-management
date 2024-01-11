package dev.serhat.customerOrder.controller;

import dev.serhat.customerOrder.dto.CreateOrderRequest;
import dev.serhat.customerOrder.dto.OrderDto;
import dev.serhat.customerOrder.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody CreateOrderRequest request){
        return ResponseEntity.ok(orderService.create(request));
    }
}
