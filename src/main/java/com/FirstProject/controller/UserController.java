package com.FirstProject.controller;

import com.FirstProject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.FirstProject.model.User;

import java.util.List;

@RestController
@RequestMapping("/apis")
public class UserController {
    private UserService userService;
    @PostMapping("/Users")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
       User savedUser= userService.createUser(user);
       return  new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId)
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
    @GetMapping("/user/userId")
    public ResponseEntity<User> getUserById(@PathVariable Long userId)
    {
       User user= userService.getSingleUser(userId);
       return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
