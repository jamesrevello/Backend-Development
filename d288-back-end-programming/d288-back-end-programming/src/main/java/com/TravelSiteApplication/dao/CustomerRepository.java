package com.TravelSiteApplication.dao;

import com.TravelSiteApplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "customers", path="customers")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
