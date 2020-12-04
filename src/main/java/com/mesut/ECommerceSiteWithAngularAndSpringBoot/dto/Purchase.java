package com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto;

import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Address;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Customer;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Order;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
