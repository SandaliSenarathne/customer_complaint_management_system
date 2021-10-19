package com.sandali.CustomerComplaintManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JsonIgnore
    private Package pkg;

    @NonNull
    private boolean isActive = true;

    @NonNull
    private Timestamp createdAt;

    public Subscription() {
    }

    public Subscription(Integer id, Customer customer, Package pkg, boolean isActive, @NonNull Timestamp createdAt) {
        this.id = id;
        this.customer = customer;
        this.pkg = pkg;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Package getPkg() {
        return pkg;
    }

    public void setPkg(Package pkg) {
        this.pkg = pkg;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @NonNull
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
