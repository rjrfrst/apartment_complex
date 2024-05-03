package com.project.ApartmentComplexServer.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private int phoneNumber;

    @Column
    private String email;

    //Extension, turn password to a hash
    @Column
    private String password;

    //Create a role for the user
    //They can either be a tenant or the landlord

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private List<Apartment> apartments;



    //Constructor
    public User(String name, int phoneNumber, String email, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
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
