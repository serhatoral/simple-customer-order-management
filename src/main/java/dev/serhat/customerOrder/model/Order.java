package dev.serhat.customerOrder.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "orders") // burada orders olarak kimliklendirmezsem(identifier) hibernate karışıklık olabilir diyerek uyarı hatası veriyor
public class Order {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator  //  @GenericGenerator(name = "UUID", type = UuidGenerator.class)
    private String id;
    private Calendar orderDate;
    private String product;
    private BigDecimal amount = new BigDecimal(0);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private  Customer customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderTransaction> orderTransactions = new HashSet<>();


    public Order() {
    }

    public Order(String id, Calendar orderDate, String product, BigDecimal amount, Customer customer) {
        this.id = id;
        this.orderDate = orderDate;
        this.product = product;
        this.amount = amount;
        this.customer = customer;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Set<OrderTransaction> getOrderTransactions() {
        return orderTransactions;
    }

    public void setOrderTransactions(Set<OrderTransaction> orderTransactions) {
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

    public void setOrderDate(GregorianCalendar orderDate) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
