package com.example.BlogRestaurante.services;

import com.example.BlogRestaurante.entities.Role;
import com.example.BlogRestaurante.entities.User;
import com.example.BlogRestaurante.repositories.RoleRepository;
import com.example.BlogRestaurante.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("LIMITED");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }
    @Override
    public Iterable<User> listAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public void saveUserEdited(User user){

        userRepository.save(user);
    }
}