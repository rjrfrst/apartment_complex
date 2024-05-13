package com.project.ApartmentComplexServer.controllers;

import com.project.ApartmentComplexServer.models.User;
import com.project.ApartmentComplexServer.repositories.UserRepository;
import com.project.ApartmentComplexServer.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;
//   This is where the crud functions (Post, Patch, Delete, Get) belong

    //create a new tenant
    @PostMapping("/{newPersonid}")
    public ResponseEntity<User> createANewUser(
            @PathVariable long newPersonId,
            @RequestBody User newUser
    ) {
        try {
            User createdUser = userService.addNewUser(newUser, newPersonId);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (ErrorResponseException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //finding all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsersInBuilding(){
        List<User> users = userService.displayAllUsersInBuilding();
        //If ? user is empty, = not found
        //Else : = ok
        return new ResponseEntity<>(users, users.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }


} //last
