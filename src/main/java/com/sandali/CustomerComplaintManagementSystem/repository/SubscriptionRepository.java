package com.sandali.CustomerComplaintManagementSystem.repository;

import com.sandali.CustomerComplaintManagementSystem.models.Package;
import com.sandali.CustomerComplaintManagementSystem.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    Subscription findSubscriptionById(Integer id);
}
