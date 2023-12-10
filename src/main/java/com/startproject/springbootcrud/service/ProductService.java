package com.startproject.springbootcrud.service;

import com.startproject.springbootcrud.entity.Product;
import com.startproject.springbootcrud.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repository;

    public Product saveProduct(Product product)
    {
       return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products )
    {
        return repository.saveAll(products);
    }

    public Product getProductById(int id)
    {
        return repository.findById(id).orElse(null);
    }
    public Product getProductByName(String name)
    {
        return repository.findByName(name);
    }
    public List<Product> getProducts()
    {
        return repository.findAll();
    }

    public String deleteProductById(int id)
    {
        repository.deleteById(id);
        return "product with ID "+ id +" was removed";
    }
    public Product updateProduct(Product product)
    {
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}
