package com.example.simplewebJDBC2.service;

import com.example.simplewebJDBC2.model.Product;
import com.example.simplewebJDBC2.repository.CRUD_Operation_using_JDBC;
import org.springframework.stereotype.Service;
import java.util.*;

@Service//@component can also be used
public class ProductService
{
    public List<Product> getProduct()
    {
        return CRUD_Operation_using_JDBC.getAllProduct();
    }

    public  Product ByProductID(int pID)
    {
        return (Product) CRUD_Operation_using_JDBC.getByID(pID);
    }
    public void addProduct(Product product)
    {
        CRUD_Operation_using_JDBC.InsertProduct(product);

    }

    public void updateProduct(Product prod)
    {
        CRUD_Operation_using_JDBC.updateByProductID(prod);
    }

    public void deleteByID(int prodID)
    {
        CRUD_Operation_using_JDBC.deleteByProductID(prodID);
    }
}
