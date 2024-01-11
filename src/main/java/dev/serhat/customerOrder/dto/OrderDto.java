package dev.serhat.customerOrder.dto;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

public class OrderDto {

    private String id;
    private Calendar orderDate;

    private String product;

    private BigDecimal amount ;

    private CustomerDto customerDto;

    private Set<OrderTransactionDto> orderTransactions;

    public OrderDto(String id, Calendar orderDate, String product, BigDecimal amount, CustomerDto customerDto, Set<OrderTransactionDto> orderTransactions) {
        this.id = id;
        this.orderDate = orderDate;
        this.product = product;
        this.amount = amount;
        this.customerDto = customerDto;
        this.orderTransactions = orderTransactions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public Set<OrderTransactionDto> getOrderTransactions() {
        return orderTransactions;
    }

    public void setOrderTransactions(Set<OrderTransactionDto> orderTransactions) {
        this.orderTransactions = orderTransactions;
    }
}
