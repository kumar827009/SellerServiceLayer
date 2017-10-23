package com.jupiter.beans;

public class Seller extends User {
    String ownerName = null;

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


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


}
