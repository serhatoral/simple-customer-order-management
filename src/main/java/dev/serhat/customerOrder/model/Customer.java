package dev.serhat.customerOrder.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.Set;


@Entity
public class Customer {


    /*
       -- UUIDGenerator hibernate 6.0 dan itibaren deprecate olmuş. Bunun yerine UuidGenerator kullanılmakta.
       -- @GenericGenerator anatosyonunda strategy elementi deprecate edilmiş (6.2 den itibaren). Bunun yerie type kullanılmakta.
            farkları ise;  strategy String değer alırken, type class almaktadır.
     */

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private String id;
    private String name;
    private String username;
    private String phoneNumber;
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    public Customer() {
    }

    public Customer(String id, String name, String username, String phoneNumber, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

       // if(!(o instanceof Customer)) return  false;

        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orders=" + orders +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
