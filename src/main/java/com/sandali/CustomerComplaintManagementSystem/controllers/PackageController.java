package com.sandali.CustomerComplaintManagementSystem.controllers;

import com.sandali.CustomerComplaintManagementSystem.models.Customer;
import com.sandali.CustomerComplaintManagementSystem.models.Package;
import com.sandali.CustomerComplaintManagementSystem.repository.CustomerRepository;
import com.sandali.CustomerComplaintManagementSystem.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/packages")
public class PackageController {
    @Autowired
    private PackageRepository packageRepository;

    @GetMapping("/list")
    public Iterable<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Package findPackageById(@PathVariable Integer id) {
        return packageRepository.findPackageById(id);
    }

    @PostMapping("/add")
    public String addPackage(@RequestParam String packageName,
                              @RequestParam String packageDesc, @RequestParam int monthlyFee) {
        Package p = new Package();
        p.setPackageName(packageName);
        p.setPackageDesc(packageDesc);
        p.setMonthlyFee(monthlyFee);
        packageRepository.save(p);
        return "Added new package successfully";
    }

    @PutMapping("/edit/{id}")
    public String editPackage(@PathVariable Integer id, @RequestParam String packageName,
                              @RequestParam String packageDesc, @RequestParam int monthlyFee) {
        Package p = this.findPackageById(id);
        p.setPackageName(packageName);
        p.setPackageDesc(packageDesc);
        p.setMonthlyFee(monthlyFee);
        packageRepository.save(p);
        return "Edited package successfully";
    }

    @DeleteMapping("/delete/{id}")
    private String deletePackage(@PathVariable Integer id) {
        packageRepository.delete(this.findPackageById(id));
        return "Deleted package successfully";
    }

}
