package com.sandali.CustomerComplaintManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "package")
public class Package {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String packageName;
    @NonNull
    private String packageDesc;
    @NonNull
    private int monthlyFee;
    @NonNull
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    @OneToMany(targetEntity = Subscription.class, mappedBy = "pkg",  cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Subscription> subscriptions;

    public Package() {
    }

    public Package(Integer id, @NonNull String packageName, @NonNull String packageDesc, int monthlyFee, @NonNull Timestamp createdAt, Set<Subscription> subscriptions) {
        this.id = id;
        this.packageName = packageName;
        this.packageDesc = packageDesc;
        this.monthlyFee = monthlyFee;
        this.createdAt = createdAt;
        this.subscriptions = subscriptions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NonNull
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(@NonNull String packageName) {
        this.packageName = packageName;
    }

    @NonNull
    public String getPackageDesc() {
        return packageDesc;
    }

    public void setPackageDesc(@NonNull String packageDesc) {
        this.packageDesc = packageDesc;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(int monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    @NonNull
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
