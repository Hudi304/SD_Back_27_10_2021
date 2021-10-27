package com.example.ProiectDistributedSystems.repository;

import com.example.ProiectDistributedSystems.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
