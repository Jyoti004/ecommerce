package com.springbootproject.ecommerce.service;

import com.springbootproject.ecommerce.model.Product;
import com.springbootproject.ecommerce.model.dao.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts(){
        return productDAO.findAll();
    }
}
