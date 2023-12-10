package com.startproject.springbootcrud.repository;

import com.startproject.springbootcrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
Product findByName(String name);
}
