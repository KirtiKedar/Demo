package com.FirstProject.service.impl;
import com.FirstProject.model.User;
import com.FirstProject.repository.UserRepository;
import com.FirstProject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        logger.info("Initiating Dao call for save the data");
      User savedUser= userRepository.save(user);
      logger.info("completed the request for save user data");
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
        logger.info("Initiating Dao call for get single user data as userid{}",userid);
        User user= userRepository.findById(userid).orElseThrow(()->new RuntimeException("user not exist"));
        logger.info("Completed Dao call for get single user data as userid{}",userid);

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
