package dev.serhat.customerOrder.dto;


import dev.serhat.customerOrder.model.OrderStatus;
import java.util.Calendar;



public class OrderTransactionDto {

    private String id;

    private Calendar transactionDate;

    private OrderStatus orderStatus ;

    private String explanation;


    public OrderTransactionDto(String id, Calendar transactionDate, OrderStatus orderStatus, String explanation) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.orderStatus = orderStatus;
        this.explanation = explanation;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Calendar getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Calendar transactionDate) {
        this.transactionDate = transactionDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
