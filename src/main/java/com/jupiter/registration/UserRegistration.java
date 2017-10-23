package com.jupiter.registration;

import com.jupiter.beans.User;

public interface UserRegistration {

    /**
     * API for registering user to platform (SELLER DB)
     *
     * @param user
     */
    public int registerUser(User user);


    /**
     * Deletes a user from SELLER DB
     *
     * @param user
     */
    public int unregisterUser(User user);
}
