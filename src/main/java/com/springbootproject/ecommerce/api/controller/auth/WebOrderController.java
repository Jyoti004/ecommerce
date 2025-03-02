package com.springbootproject.ecommerce.api.controller.auth;

import com.springbootproject.ecommerce.model.LocalUser;
import com.springbootproject.ecommerce.model.WebOrder;
import com.springbootproject.ecommerce.service.WebOrderService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class WebOrderController {

    private WebOrderService webOrderService;

    public WebOrderController(WebOrderService webOrderService) {
        this.webOrderService = webOrderService;
    }

    @GetMapping
    public List<WebOrder> getOrderByUser(@AuthenticationPrincipal LocalUser user){
        return webOrderService.getOrderByUser(user);
    }
}
