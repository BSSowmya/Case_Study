package com.javamaster.transport.dao;

import com.javamaster.transport.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long>{
//    Optional<User> authenticateUser(String username, String password);
}
