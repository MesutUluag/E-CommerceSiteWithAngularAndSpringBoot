package com.mesut.ECommerceSiteWithAngularAndSpringBoot.dao;

import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
//    http://localhost:8080/api/products/search/findByCategoryId?id=1

    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
    //    http://localhost:8080/api/products/search/findByNameContaining?name=python
    // Query was SELECT * FROM Product p WHERE p.name LIKE CONCAT('%', :name, '%')
}
