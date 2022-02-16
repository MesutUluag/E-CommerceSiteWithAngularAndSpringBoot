package com.mesut.ECommerceSiteWithAngularAndSpringBoot.dao;

import com.mesut.ECommerceSiteWithAngularAndSpringBoot.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
public interface StateRepository extends JpaRepository <State, Integer> {
//    http://localhost:8081/api/states
    List<State> findByCountryCode(@Param("code") String code);
//    http://localhost:8081/api/states/search/findByCountryCode?code=IN

}
