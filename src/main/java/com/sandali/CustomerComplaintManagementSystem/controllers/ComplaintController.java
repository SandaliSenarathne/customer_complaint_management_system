package com.sandali.CustomerComplaintManagementSystem.controllers;

import com.sandali.CustomerComplaintManagementSystem.models.Complaint;
import com.sandali.CustomerComplaintManagementSystem.models.Customer;
import com.sandali.CustomerComplaintManagementSystem.repository.ComplaintRepository;
import com.sandali.CustomerComplaintManagementSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {
    @Autowired
    private ComplaintRepository complaintRepository;

    @GetMapping("/list")
    public Iterable<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Complaint findComplaintById(@PathVariable Integer id) {
        return complaintRepository.findComplaintById(id);
    }

    @PostMapping("/add")
    public String addComplaint(@RequestParam Integer subscriptionId, @RequestParam String complaint) {
        Complaint c = new Complaint();
        c.setSubscriptionId(subscriptionId);
        c.setComplaint(complaint);
        c.setSolution("Not solved yet");
        c.setStatus(0);
        complaintRepository.save(c);
        return "Added new complaint successfully";
    }

    @PutMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, @RequestParam String complaint,
                               @RequestParam String solution, @RequestParam int status) {
        Complaint c = this.findComplaintById(id);
        c.setComplaint(complaint);
        c.setSolution(solution);
        c.setStatus(status);
        complaintRepository.save(c);
        return "Edited customer successfully";
    }

    @DeleteMapping("/delete/{id}")
    private String deleteComplaint(@PathVariable Integer id)
    {
        complaintRepository.delete(this.findComplaintById(id));
        return "Deleted complaint successfully";
    }

}
