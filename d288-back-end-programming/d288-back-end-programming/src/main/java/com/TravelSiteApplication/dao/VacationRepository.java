package com.TravelSiteApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "vacations", path="vacations")
public interface VacationRepository extends JpaRepository<com.TravelSiteApplication.entity.Vacation, Long> {
}
