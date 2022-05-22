package com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto;

import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Address;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Customer;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Order;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.OrderItem;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import java.util.Set;

@Data
@Builder
public class Purchase {

    @NotNull
    @Valid
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    @NotNull
    @Valid
    private Order order;

    @NotNull
    @Valid
    private Set<OrderItem> orderItems;
}
