package com.sandali.CustomerComplaintManagementSystem.repository;

import com.sandali.CustomerComplaintManagementSystem.models.Complaint;
import com.sandali.CustomerComplaintManagementSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {
    Complaint findComplaintById(Integer id);
}
