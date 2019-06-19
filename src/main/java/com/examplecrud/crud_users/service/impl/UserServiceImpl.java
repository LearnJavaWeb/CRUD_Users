package com.examplecrud.crud_users.service.impl;

import com.examplecrud.crud_users.model.User;
import com.examplecrud.crud_users.repository.UserRepository;
import com.examplecrud.crud_users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }
}
