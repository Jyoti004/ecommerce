package com.springbootproject.ecommerce.model.dao;

import com.springbootproject.ecommerce.model.LocalUser;
import com.springbootproject.ecommerce.model.WebOrder;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface WebOrderDAO extends ListCrudRepository<WebOrder, Long> {

    public List<WebOrder> findByUser(LocalUser user);
}
