package com.example.BlogRestaurante.services;

import com.example.BlogRestaurante.entities.User;

/**
 * Created by amolina on 10/05/17.
 */
public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
    Iterable<User> listAllUsers();
    User getUserById(Integer id);
    void deleteUser(Integer id);
    void saveUserEdited(User user);
}