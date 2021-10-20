package com.sandali.CustomerComplaintManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class CustomerComplaintManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerComplaintManagementSystemApplication.class, args);
	}

	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}

}
