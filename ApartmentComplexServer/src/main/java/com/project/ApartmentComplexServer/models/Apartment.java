package com.project.ApartmentComplexServer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apartment")
public class Apartment {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int apartmentNumber;
    private int numberOfBedrooms;

    //An apartment can have many users and users can live in one apartment
    //Many to Many = @JoinTable
    @ManyToMany
    @JoinTable(
            name = "user_apartment", //name of the new joined table
            joinColumns = @JoinColumn(name = "apartment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    //Many apartments belong to one building
    @ManyToOne
    @JoinColumn(name = "building_id")
    @JsonIgnoreProperties
    private Building building;

    //constructor
    public Apartment(int apartmentNumber, int numberOfBedrooms) {
        this.apartmentNumber = apartmentNumber;
        this.numberOfBedrooms = numberOfBedrooms;
        this.users = new ArrayList<>();
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public Building getBuilding() {
        return building;
    }
    public void setBuilding(Building building) {
        this.building = building;
    }

} //last
