package com.FirstProject.service.impl;
import com.FirstProject.model.User;
import com.FirstProject.repository.UserRepository;
import com.FirstProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
      User savedUser= userRepository.save(user);
        return savedUser;
    }

    @Override
    public User updateUser(Long userId, User user) {
    User user1= userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
          user1.setUserName(user.getUserName());
          user1.setAbout(user.getAbout());
        return user1;
    }

    @Override
    public User getSingleUser(Long userid) {
       User user= userRepository.findById(userid).orElseThrow(()->new RuntimeException("user not exist"));
        return user ;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users=userRepository.findAll();
        return users;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
