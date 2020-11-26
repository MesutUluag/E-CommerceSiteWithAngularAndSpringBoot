package com.mesut.ECommerceSiteWithAngularAndSpringBoot.dao;

import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
