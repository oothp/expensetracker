package com.migle.expensetracker.repositories;

import com.migle.expensetracker.domain.User;
import com.migle.expensetracker.exceptions.EtAuthException;

public interface UserRepository {
    // methid name reflects db operations
    Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;

    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
