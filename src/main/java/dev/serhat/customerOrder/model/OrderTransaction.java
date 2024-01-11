package dev.serhat.customerOrder.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Calendar;
import java.util.Objects;

@Entity
public class OrderTransaction {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private String id;

    private Calendar transactionDate;
    private OrderStatus orderStatus = OrderStatus.ORDER_RECEIVED;
    private String explanation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderTransaction() {
    }

    public OrderTransaction(String id, OrderStatus orderStatus, String explanation, Order order) {
        this.id = id;
        this.transactionDate = Calendar.getInstance();
        this.orderStatus = orderStatus;
        this.explanation = explanation;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderTransaction that = (OrderTransaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}



