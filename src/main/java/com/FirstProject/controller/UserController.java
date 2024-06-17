package com.FirstProject.controller;

import com.FirstProject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.FirstProject.model.User;

import java.util.List;

@RestController
@RequestMapping("/apis")
public class UserController {
    Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        logger.info("enterning the request for save data");
       User savedUser= userService.createUser(user);
       return  new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser( @PathVariable Long userId,@RequestBody User user)
    {
       User updatedUser= userService.updateUser(userId,user);
    return new ResponseEntity<>(updatedUser,HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers()
    {
       List<User> users=userService.getAllUsers();
       return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity("user deleted successfully",HttpStatus.OK);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId)
    {
        logger.info("Entering the request for get user data using userId{}",userId);
       User user= userService.getSingleUser(userId);
        logger.info("Completed the request for get user data using userId{}",userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
