package com.example.simplewebJDBC2.controller;

import com.example.simplewebJDBC2.model.Product;
import com.example.simplewebJDBC2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    ProductService service;

    @GetMapping("/products1")
    public List<Product> getProduct()
    {
        return service.getProduct();
    }//GET

    @GetMapping("/products1/{pID}")
    public Product getByProductID(@PathVariable  int pID)//GET
    {
        return service.ByProductID(pID);
    }

    @PostMapping("/products1")
    public void addProduct(@RequestBody Product prod)//post insert
    {
        System.out.println(prod);
        service.addProduct(prod);
    }

    @PutMapping("/products1")
    public void updateProduct(@RequestBody Product prod)
    {
        service.updateProduct(prod);
    }

    @DeleteMapping("/products1/{prodID}")
    public void deleteProductByID(@PathVariable int prodID)
    {
        service.deleteByID(prodID);
    }
}
