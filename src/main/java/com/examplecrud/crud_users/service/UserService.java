package com.examplecrud.crud_users.service;

import com.examplecrud.crud_users.model.User;

public interface UserService {
    Iterable<User> getAllUser();

    void saveUser(User user);

    void removeUser(Long id);

    User findUserById(Long id);
}
