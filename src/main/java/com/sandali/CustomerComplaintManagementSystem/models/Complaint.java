package com.sandali.CustomerComplaintManagementSystem.models;

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
    private Integer subscriptionId;
    private String complaint;
    private String solution;
    private int status; // 0 - Pending, 1 - Solved
    private Timestamp createdAt;

    public Complaint() {
    }

    public Complaint(Integer id, Integer subscriptionId, String complaint, String solution, int status, Timestamp createdAt) {
        this.id = id;
        this.subscriptionId = subscriptionId;
        this.complaint = complaint;
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

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
