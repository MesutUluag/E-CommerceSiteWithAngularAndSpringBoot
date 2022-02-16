package com.mesut.ECommerceSiteWithAngularAndSpringBoot.dao;

import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
