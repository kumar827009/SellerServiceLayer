package com.jupiter.beans;

public class Seller {
    String id = null;
    String name = null;
    String ownerName = null;
    Address address = null;

    public Seller() {
        super();
    }

    public Seller(String name, String ownerName, Address address) {
        this.id = id;
        this.name = name;
        this.ownerName = ownerName;
        this.address = address;
    }

    public Seller(String id, String name, String ownerName, Address address) {
        this.id = id;
        this.name = name;
        this.ownerName = ownerName;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
