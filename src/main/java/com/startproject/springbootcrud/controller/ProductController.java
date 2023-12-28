package com.startproject.springbootcrud.controller;

import com.startproject.springbootcrud.entity.Product;
import com.startproject.springbootcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products)
    {
       return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts()
    {
        return service.getProducts();
    }

    @GetMapping(path = "/productById/{id}",produces= MediaType.APPLICATION_XML_VALUE)
    public Product findProductById(@PathVariable int id)
    {
        return service.getProductById(id);
    }

    @GetMapping("/productByName/{name}")
    public Product findProductByName(@PathVariable String name)
    {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product)
    {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        return service.deleteProductById(id);
    }

}
