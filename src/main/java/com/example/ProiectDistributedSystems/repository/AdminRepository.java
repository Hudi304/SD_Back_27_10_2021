package com.example.ProiectDistributedSystems.repository;

import com.example.ProiectDistributedSystems.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdminRepository extends JpaRepository<Admin,Long> {

    Admin findFirstByNameAndPassword(String name, String password);
}
