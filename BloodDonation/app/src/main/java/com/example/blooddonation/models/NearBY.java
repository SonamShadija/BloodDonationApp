package com.example.blooddonation.models;

import java.security.Identity;

public class NearBY {
    String phone;
    String name,address,bloodType;
    Long capacity;



    public NearBY(String name, String address, String bloodType, Long capacity, String phone) {
        this.name = name;
        this.address = address;
        this.bloodType = bloodType;
        this.capacity = capacity;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
