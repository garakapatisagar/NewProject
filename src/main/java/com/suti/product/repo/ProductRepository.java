package com.suti.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suti.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
