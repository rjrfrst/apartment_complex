package com.project.ApartmentComplexServer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name ="building")
public class Building {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int floorNumber;
    private int roomsPerFloor;

    //There is one building and many apartments
    //One to many
    @OneToMany(mappedBy = "building")
    @Column
    @JsonIgnoreProperties({"building"})
    private List<Apartment> apartments;

    public Building(int floorNumber, int roomsPerFloor) {
        this.floorNumber = floorNumber;
        this.roomsPerFloor = roomsPerFloor;
        this.apartments = new ArrayList<>();
    }

    //empty constructor
    public Building() {
    }

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getRoomsPerFloor() {
        return roomsPerFloor;
    }

    public void setRoomsPerFloor(int roomsPerFloor) {
        this.roomsPerFloor = roomsPerFloor;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }


} //last
