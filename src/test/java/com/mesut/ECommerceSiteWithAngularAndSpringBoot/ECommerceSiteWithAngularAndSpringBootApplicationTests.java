package com.mesut.ECommerceSiteWithAngularAndSpringBoot;

import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dao.CustomerRepository;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto.Purchase;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto.PurchaseResponse;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Customer;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Order;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.OrderItem;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.service.CheckoutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.math.BigDecimal;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ECommerceSiteWithAngularAndSpringBootApplicationTests {

    @Autowired
    private CheckoutService checkoutService;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    void placeOrderTest() {
        // initialize objects
        String email = "test@test.com";
        Order order = new Order(123456L, "123456", 1, new BigDecimal(10), "A", new Date(), null, null, null, null, null);
        OrderItem orderItem = OrderItem.builder().unitPrice(new BigDecimal("10")).quantity(1).productId(123456L).build();
        Customer customer = new Customer(123456L, "Mesut", "Uluag", "test@test.com", null);
        Purchase purchase = Purchase.builder().customer(customer).order(order).orderItems(Set.of(orderItem)).build();

        // mock dependencies
        when(customerRepository.findByEmail(email)).thenReturn(customer);
        when(customerRepository.save(customer)).thenReturn(customer);

        // place the order
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        boolean result;
        if (purchaseResponse.getOrderTrackingNumber() instanceof String) {
            result = true;
        } else {
            result = false;
        }
        assertEquals(true, result);
    }
}
