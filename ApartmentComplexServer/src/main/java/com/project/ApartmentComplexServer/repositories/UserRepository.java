package com.project.ApartmentComplexServer.repositories;

import com.project.ApartmentComplexServer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Repositories are abstract and should be the one connecting to the database

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



} //last
