package com.springbootproject.ecommerce.service;

import com.springbootproject.ecommerce.model.LocalUser;
import com.springbootproject.ecommerce.model.WebOrder;
import com.springbootproject.ecommerce.model.dao.WebOrderDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebOrderService {

    private WebOrderDAO webOrderDAO;


    public WebOrderService(WebOrderDAO webOrderDAO) {
        this.webOrderDAO = webOrderDAO;
    }

    public List<WebOrder> getOrderByUser(LocalUser user){
        return webOrderDAO.findByUser(user);
    }
}
