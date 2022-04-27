package com.migle.expensetracker.services;

import com.migle.expensetracker.domain.User;
import com.migle.expensetracker.exceptions.EtAuthException;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}
