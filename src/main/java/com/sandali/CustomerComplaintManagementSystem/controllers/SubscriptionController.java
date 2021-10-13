package com.sandali.CustomerComplaintManagementSystem.controllers;

import com.sandali.CustomerComplaintManagementSystem.models.Package;
import com.sandali.CustomerComplaintManagementSystem.models.Subscription;
import com.sandali.CustomerComplaintManagementSystem.repository.PackageRepository;
import com.sandali.CustomerComplaintManagementSystem.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @GetMapping("/list")
    public Iterable<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Subscription findSubscriptionById(@PathVariable Integer id) {
        return subscriptionRepository.findSubscriptionById(id);
    }

    @PostMapping("/add")
    public String addSubscription(@RequestParam Integer customerId,
                              @RequestParam Integer packageId) {
        Subscription subscription = new Subscription();
        subscription.setCustomerId(customerId);
        subscription.setPackageId(packageId);
        subscription.setActive(true);
        subscriptionRepository.save(subscription);
        return "Added new subscription successfully";
    }

    @PutMapping("/edit/{id}")
    public String editSubscription(@PathVariable Integer id, @RequestParam Integer customerId,
                              @RequestParam Integer packageId, @RequestParam boolean isActive) {
        Subscription subscription = this.findSubscriptionById(id);
        subscription.setCustomerId(customerId);
        subscription.setPackageId(packageId);
        subscription.setActive(isActive);
        subscriptionRepository.save(subscription);
        return "Edited subscription successfully";
    }

    @DeleteMapping("/delete/{id}")
    private String deleteSubscription(@PathVariable Integer id) {
        subscriptionRepository.delete(this.findSubscriptionById(id));
        return "Deleted subscription successfully";
    }

}
