package com.mesut.ECommerceSiteWithAngularAndSpringBoot.controller;

import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto.Purchase;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto.PurchaseResponse;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;

    @Autowired
    CheckoutController(CheckoutService checkoutService){
        this.checkoutService=checkoutService;
    }


    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse= checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
