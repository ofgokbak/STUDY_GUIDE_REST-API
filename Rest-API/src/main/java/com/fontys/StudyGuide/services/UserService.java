package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Users.User;
import com.fontys.StudyGuide.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }
    public User getUser(int pcn)
    {
        return userRepository.findByPcn(pcn);
    }
}
