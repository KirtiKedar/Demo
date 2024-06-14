package com.FirstProject.service;

import com.FirstProject.model.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public User updateUser(Long userId,User user);
    public User getSingleUser(Long userid);
    public List<User> getAllUsers();
   public void deleteUser(Long userId);

}
