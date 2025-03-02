package com.springbootproject.ecommerce.model.dao;

import com.springbootproject.ecommerce.model.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductDAO extends ListCrudRepository<Product, Long> {
}
