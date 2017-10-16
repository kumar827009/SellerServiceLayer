package com.jupiter.beans;

public class Address {
    String email = null;
    String city = null;
    String addressLineOne = null;
    String addressLineTwo = null;
    String pin = "";

    public Address() {
        super();
    }

    @Override
    public String toString() {
        return "Address{" +
                "email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", addressLineOne='" + addressLineOne + '\'' +
                ", addressLineTwo='" + addressLineTwo + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }

    public Address(String email, String city, String addressLineOne, String addressLineTwo, String pin) {
        this.email = email;
        this.city = city;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.pin = pin;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public String getPin() {
        return pin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
