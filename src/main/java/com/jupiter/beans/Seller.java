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

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
