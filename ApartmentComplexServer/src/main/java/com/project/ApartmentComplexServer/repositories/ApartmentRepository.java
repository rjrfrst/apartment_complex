package com.project.ApartmentComplexServer.repositories;

import com.project.ApartmentComplexServer.models.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

} //last
