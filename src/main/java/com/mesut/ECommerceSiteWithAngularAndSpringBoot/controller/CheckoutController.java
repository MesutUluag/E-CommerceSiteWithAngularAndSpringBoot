package com.mesut.ECommerceSiteWithAngularAndSpringBoot.controller;

import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto.PaymentInfo;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto.Purchase;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto.PurchaseResponse;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.service.CheckoutService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;

    @Autowired
    CheckoutController(CheckoutService checkoutService){
        this.checkoutService=checkoutService;
    }


    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody @Valid Purchase purchase){
        return checkoutService.placeOrder(purchase);
    }

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException{
        PaymentIntent paymentIntent = checkoutService.createPaymentIntent(paymentInfo);
        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }
}
