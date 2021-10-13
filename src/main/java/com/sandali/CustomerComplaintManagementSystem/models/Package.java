package com.sandali.CustomerComplaintManagementSystem.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "package")
public class Package {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String packageName;
    private String packageDesc;
    private int monthlyFee;
    private Timestamp createdAt;

    public Package() {
    }

    public Package(Integer id, String packageName, String packageDesc, int monthlyFee, Timestamp createdAt) {
        this.id = id;
        this.packageName = packageName;
        this.packageDesc = packageDesc;
        this.monthlyFee = monthlyFee;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageDesc() {
        return packageDesc;
    }

    public void setPackageDesc(String packageDesc) {
        this.packageDesc = packageDesc;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(int monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
