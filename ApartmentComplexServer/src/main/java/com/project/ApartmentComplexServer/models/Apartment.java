package com.project.ApartmentComplexServer.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "apartment")
public class Apartment {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    //An apartment can have many users and users can live in one apartment
    //Many to one
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int apartmentNumber;
    private int numberOfBedrooms;


    //constructor
    public Apartment(User user, int apartmentNumber, int numberOfBedrooms) {
        this.user = user;
        this.apartmentNumber = apartmentNumber;
        this.numberOfBedrooms = numberOfBedrooms;
    }

    //empty constructor
    public Apartment() {
    }

    //Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
} //last
