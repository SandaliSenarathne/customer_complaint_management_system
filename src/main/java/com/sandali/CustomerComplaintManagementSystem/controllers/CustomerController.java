package com.sandali.CustomerComplaintManagementSystem.controllers;

import com.sandali.CustomerComplaintManagementSystem.models.Customer;
import com.sandali.CustomerComplaintManagementSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    public String viewComplaintsPage(Model model) {
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

//    @PostMapping("/add")
//    public String addCustomer(@RequestParam String firstName,
//                              @RequestParam String lastName, @RequestParam String nic,
//                              @RequestParam String phone, @RequestParam String email) {
//        Customer customer = new Customer();
//        customer.setFirstName(firstName);
//        customer.setLastName(lastName);
//        customer.setNic(nic);
//        customer.setPhone(phone);
//        customer.setEmail(email);
//        customerRepository.save(customer);
//        return "Added new customer successfully";
//    }

//    @PutMapping("/edit/{id}")
//    public String editCustomer(@PathVariable Integer id, @RequestParam String firstName,
//                               @RequestParam String lastName, @RequestParam String nic,
//                               @RequestParam String phone, @RequestParam String email) {
//        Customer customer = this.findCustomerById(id);
//        customer.setFirstName(firstName);
//        customer.setLastName(lastName);
//        customer.setNic(nic);
//        customer.setPhone(phone);
//        customer.setEmail(email);
//        customerRepository.save(customer);
//        return "Edited customer successfully";
//    }

    @DeleteMapping("/delete/{id}")
    private String deleteCustomer(@PathVariable Integer id)
    {
        customerRepository.delete(this.findCustomerById(id));
        return "Deleted package successfully";
    }

}
