package com.store.shoppingcart.controller;

import com.store.shoppingcart.domain.ShoppingCart;
import com.store.shoppingcart.service.ShoppingCartService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/shopping-cart")
public class ShoppingCartController extends GenericController<ShoppingCart> {
    public ShoppingCartController(ShoppingCartService service){
        super(service);
    }
}