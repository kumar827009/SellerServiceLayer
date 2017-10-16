package com.jupiter.registration;

import com.jupiter.beans.User;

public interface UserRegistration {

    /**
     * API for registering user to platform (SELLER DB)
     *
     * @param user
     */
    public void registerUser(User user);


    /**
     * Deletes a user from SELLER DB
     *
     * @param user
     */
    public void unregisterUser(User user);
}
