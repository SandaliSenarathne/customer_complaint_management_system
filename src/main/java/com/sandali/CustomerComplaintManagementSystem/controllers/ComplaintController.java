package com.sandali.CustomerComplaintManagementSystem.controllers;

import com.sandali.CustomerComplaintManagementSystem.models.Complaint;
import com.sandali.CustomerComplaintManagementSystem.models.Customer;
import com.sandali.CustomerComplaintManagementSystem.models.Subscription;
import com.sandali.CustomerComplaintManagementSystem.repository.ComplaintRepository;
import com.sandali.CustomerComplaintManagementSystem.repository.CustomerRepository;
import com.sandali.CustomerComplaintManagementSystem.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/complaints")
public class ComplaintController {
    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @GetMapping("")
    public String viewComplaintsPage(Model model) {
        List<Complaint> listComplaints = this.getAllComplaints();
        model.addAttribute("listComplaints", listComplaints);
        return "complaints";
    }

    @GetMapping("/add-form")
    public String viewAddComplaintPage(Model model) {
        Complaint complaint = new Complaint();
        model.addAttribute("complaint", complaint);
        model.addAttribute("listSubscriptions", subscriptionRepository.findAll());
        return "add_complaint";
    }

    @GetMapping("/edit-form/{id}")
    public String showEditComplaintPage(@PathVariable(name = "id") int id, Model model) {
        Complaint complaint = complaintRepository.findComplaintById(id);
        model.addAttribute("complaint", complaint);
        return "edit_complaint";
    }

    //------------------------------------------------------------------------------------------------

    @GetMapping("/list")
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Complaint findComplaintById(@PathVariable Integer id) {
        return complaintRepository.findComplaintById(id);
    }

    @PostMapping("/add")
    public String addComplaint(@ModelAttribute("complaint") Complaint complaint){
        complaintRepository.save(complaint);
        return "redirect:/complaints";
    }

    @PutMapping("/edit")
    public String editComplaint(@ModelAttribute("complaint") Complaint complaint) {
        complaintRepository.save(complaint);
        return "redirect:/complaints";
    }

    @DeleteMapping("/delete/{id}")
    private String deleteComplaint(@PathVariable Integer id)
    {
        complaintRepository.delete(this.findComplaintById(id));
        return "redirect:/complaints";
    }

}
