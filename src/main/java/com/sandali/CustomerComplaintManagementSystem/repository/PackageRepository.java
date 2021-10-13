package com.sandali.CustomerComplaintManagementSystem.repository;

import com.sandali.CustomerComplaintManagementSystem.models.Customer;
import com.sandali.CustomerComplaintManagementSystem.models.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<Package, Integer> {
    Package findPackageById(Integer id);
}
