package com.javamaster.transport.service;

import com.javamaster.transport.model.User;

import java.util.Optional;

public interface IUserService {
    User save(User user);

    Optional<User> findByUsername(String username);
}
