package com.mesut.ECommerceSiteWithAngularAndSpringBoot.service;

import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto.Purchase;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
