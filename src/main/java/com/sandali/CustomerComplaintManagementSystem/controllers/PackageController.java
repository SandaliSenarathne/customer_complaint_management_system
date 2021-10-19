package com.sandali.CustomerComplaintManagementSystem.controllers;

import com.sandali.CustomerComplaintManagementSystem.models.Customer;
import com.sandali.CustomerComplaintManagementSystem.models.Package;
import com.sandali.CustomerComplaintManagementSystem.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/packages")
public class PackageController {
    @Autowired
    private PackageRepository packageRepository;

    @GetMapping("")
    public String viewPackagesPage(Model model) {
        List<Package> listPackages = this.getAllPackages();
        model.addAttribute("listPackages", listPackages);
        return "packages";
    }

    @GetMapping("/add")
    public String viewAddPackagePage(Model model) {
        Package p = new Package();
        model.addAttribute("package", p);

        return "add_package";
    }

    @PostMapping("/save")
    public String savePackage(@ModelAttribute("package") Package p){
        packageRepository.save(p);

        return "redirect:/packages";
    }

    @GetMapping("/list")
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Package findPackageById(@PathVariable Integer id) {
        return packageRepository.findPackageById(id);
    }

    @DeleteMapping("/delete/{id}")
    private String deletePackage(@PathVariable Integer id) {
        packageRepository.delete(this.findPackageById(id));
        return "Deleted package successfully";
    }

}
