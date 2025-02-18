package com.TravelSiteApplication.dao;

import com.TravelSiteApplication.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "divisions", path="divisions")
public interface DivisionRepository extends JpaRepository<Division, Long> {
}
