package com.mesut.ECommerceSiteWithAngularAndSpringBoot.dao;

import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
public interface CountryRepository extends JpaRepository <Country, Integer> {
//    http://localhost:8081/api/countries to get all countries
}
