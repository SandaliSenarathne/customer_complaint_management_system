package com.sandali.CustomerComplaintManagementSystem.controllers;

import com.sandali.CustomerComplaintManagementSystem.models.Customer;
import com.sandali.CustomerComplaintManagementSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    public String viewCustomersPage(Model model) {
        List<Customer> listCustomers = this.getAllCustomers();
        model.addAttribute("listCustomers", listCustomers);
        return "customers";
    }

    @GetMapping("/add")
    public String viewAddCustomerPage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "add_customer";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditCustomerPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_customer");
        Customer customer = customerRepository.findCustomerById(id);
        mav.addObject("customer", customer);

        return mav;
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerRepository.save(customer);

        return "redirect:/customers";
    }

    @GetMapping("/list")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }

    @RequestMapping("/delete/{id}")
    private String deleteCustomer(@PathVariable Integer id) {
        customerRepository.delete(this.findCustomerById(id));
        return "redirect:/customers";
    }

}
