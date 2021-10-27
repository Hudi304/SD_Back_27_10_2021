package com.example.ProiectDistributedSystems.repository;


import com.example.ProiectDistributedSystems.model.NormalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormalUserRepository extends JpaRepository<NormalUser,Long> {
    NormalUser findFirstByNameAndPassword(String name, String password);

}
