package dev.serhat.customerOrder.dto.converter;


import dev.serhat.customerOrder.dto.OrderDto;
import dev.serhat.customerOrder.model.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final OrderTransactionConverter orderTransactionConverter;

    public OrderDtoConverter(CustomerDtoConverter customerDtoConverter, OrderTransactionConverter orderTransactionConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.orderTransactionConverter = orderTransactionConverter;
    }


    public OrderDto orderDtoFromOrder(Optional<Order> order){
        return order.map(o -> new OrderDto(
                o.getId(),
                o.getOrderDate(),
                o.getProduct(),
                o.getAmount(),
                customerDtoConverter.customerDtoFromCustomer(Optional.of(o.getCustomer())),
                o.getOrderTransactions().stream().map(orderTransactionConverter::orderTransactionDtoFromOrderTransaction)
                        .collect(Collectors.toSet())
        )).orElse(null);

    }
}
