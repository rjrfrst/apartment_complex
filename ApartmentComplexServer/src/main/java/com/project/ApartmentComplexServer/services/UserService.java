package com.project.ApartmentComplexServer.services;

import com.project.ApartmentComplexServer.models.User;
import com.project.ApartmentComplexServer.repositories.UserRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

import java.util.List;

public class UserService {

    //This is where the methods will be
    //Not the crud functions (Post, Patch, Delete, Get)

    @Autowired
    UserRepository userRepository;

    //Create a new user
    //extension, they will either be a tenant or landlord in the future.

    //
    public User addNewUser(User newUser, Long personId) {
        User person = userRepository.findById(personId).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        //save the new user
        return userRepository.save(newUser);
    }

    //Find all the users available in the apartment
    //It should return one for now
    public List<User> displayAllUsersInBuilding(){
        return userRepository.findAll();
    }



} // last
