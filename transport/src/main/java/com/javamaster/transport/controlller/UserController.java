package com.javamaster.transport.controlller;

import com.javamaster.transport.model.User;
import com.javamaster.transport.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;


    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public  User save(@RequestBody  User user){
        return userService.save(user);
    }
}
