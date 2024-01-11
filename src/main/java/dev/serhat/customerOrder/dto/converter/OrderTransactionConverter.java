package dev.serhat.customerOrder.dto.converter;

import dev.serhat.customerOrder.dto.OrderTransactionDto;
import dev.serhat.customerOrder.model.OrderTransaction;
import org.springframework.stereotype.Component;

@Component
public class OrderTransactionConverter {

    public OrderTransactionDto orderTransactionDtoFromOrderTransaction(OrderTransaction orderTransaction){


        return new OrderTransactionDto(
                orderTransaction.getId(),
                orderTransaction.getTransactionDate(),
                orderTransaction.getOrderStatus(),
                orderTransaction.getExplanation()
        );
    }
}
