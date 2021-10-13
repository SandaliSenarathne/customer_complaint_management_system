package com.sandali.CustomerComplaintManagementSystem.controllers;

import com.sandali.CustomerComplaintManagementSystem.models.Customer;
import com.sandali.CustomerComplaintManagementSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/list")
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }

    @PostMapping("/add")
    public String addCustomer(@RequestParam String firstName,
                              @RequestParam String lastName, @RequestParam String nic,
                              @RequestParam String phone, @RequestParam String email) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setNic(nic);
        customer.setPhone(phone);
        customer.setEmail(email);
        customerRepository.save(customer);
        return "Added new customer successfully";
    }

    @PutMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, @RequestParam String firstName,
                               @RequestParam String lastName, @RequestParam String nic,
                               @RequestParam String phone, @RequestParam String email) {
        Customer customer = this.findCustomerById(id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setNic(nic);
        customer.setPhone(phone);
        customer.setEmail(email);
        customerRepository.save(customer);
        return "Edited customer successfully";
    }

    @DeleteMapping("/delete/{id}")
    private String deleteCustomer(@PathVariable Integer id)
    {
        customerRepository.delete(this.findCustomerById(id));
        return "Deleted package successfully";
    }

}
