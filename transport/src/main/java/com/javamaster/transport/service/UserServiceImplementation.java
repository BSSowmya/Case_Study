package com.javamaster.transport.service;

import com.javamaster.transport.dao.IUserRepository;
import com.javamaster.transport.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImplementation implements IUserService {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }
}
