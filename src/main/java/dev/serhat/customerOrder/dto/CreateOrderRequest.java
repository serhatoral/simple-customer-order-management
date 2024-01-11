package dev.serhat.customerOrder.dto;

import java.math.BigDecimal;

public class CreateOrderRequest {

    private String customerId;

    private String product;

    private BigDecimal amount ;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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


}
