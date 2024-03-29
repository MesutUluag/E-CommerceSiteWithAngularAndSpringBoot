package com.mesut.ECommerceSiteWithAngularAndSpringBoot.service;

import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dao.CustomerRepository;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto.PaymentInfo;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto.Purchase;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.dto.PurchaseResponse;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Customer;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Order;
import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.OrderItem;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository,
                               @Value("${stripe.key.secret}") String secretKey) {
        this.customerRepository = customerRepository;
        // initialize Stripe apiKey
        Stripe.apiKey = secretKey;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(order::add);

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();

        // check whether customer exists
        String email = customer.getEmail();

        Customer customerFromDb = customerRepository.findByEmail(email);
        if (customerFromDb != null){
            customer = customerFromDb;
        }

        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    @Override
    public PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException {
        List<String> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");

        Map<String,Object> params = new HashMap<>();
        params.put("amount", paymentInfo.getAmount());
        params.put("currency", paymentInfo.getCurrency());
        params.put("receipt_email", paymentInfo.getReceiptEmail());
        params.put("payment_method_types", paymentMethodTypes);
        params.put("description", "Purchase");

        return PaymentIntent.create(params);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
}









