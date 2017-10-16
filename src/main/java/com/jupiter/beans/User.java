package com.jupiter.beans;

public class User {
    boolean isSeller = false;
    Seller seller = null;

    public User(User user) {
        this.isSeller = user.isSeller;
    }
}
