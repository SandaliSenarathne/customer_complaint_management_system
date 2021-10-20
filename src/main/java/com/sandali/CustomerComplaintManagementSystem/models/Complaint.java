package com.sandali.CustomerComplaintManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hamcrest.Condition;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "complaint")
public class Complaint {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JsonIgnore
    private Subscription subscription;
    @NonNull
    private String complaintText;
    @NonNull
    private String solution;
    @NonNull
    private int status = 0;
    @NonNull
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    public Complaint() {
    }

    public Complaint(Integer id, Subscription subscription, @NonNull String complaintText, @NonNull String solution, int status, @NonNull Timestamp createdAt) {
        this.id = id;
        this.subscription = subscription;
        this.complaintText = complaintText;
        this.solution = solution;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @NonNull
    public String getComplaintText() {
        return complaintText;
    }

    public void setComplaintText(@NonNull String complaintText) {
        this.complaintText = complaintText;
    }

    @NonNull
    public String getSolution() {
        return solution;
    }

    public void setSolution(@NonNull String solution) {
        this.solution = solution;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @NonNull
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
