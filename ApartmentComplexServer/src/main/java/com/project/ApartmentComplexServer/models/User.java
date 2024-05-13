package com.project.ApartmentComplexServer.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int phoneNumber;

    private String email;

    //Extension, turn password to a hash
    private String password;

    //Create a role for the user
    //They can either be a tenant or the landlord
    //extension

    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties({"users"})
    private List<Apartment> apartments;

    //Constructor
    public User(String name, int phoneNumber, String email, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.apartments = new ArrayList<>();
    }


    //empty constructor
    public User(){
    }

    //Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }
    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    //
} //last
