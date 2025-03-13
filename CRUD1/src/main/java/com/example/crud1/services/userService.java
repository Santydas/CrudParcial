package com.example.crud1.services;

import com.example.crud1.models.userModel;
import com.example.crud1.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class userService {

    @Autowired
    private IUserRepository userRepository;

    public ArrayList<userModel> getUsers(){
      return (ArrayList<userModel>) userRepository.findAll();
    }

    public userModel saveUser(userModel user){
        return userRepository.save(user);
    }

    public Optional<userModel> getUserById(Long id){
        return userRepository.findById(id);
    }

    public userModel updateById(userModel request, Long id){
        userModel user = userRepository.findById(id).get();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());

        return user;
    }

    public Boolean deleteUserById(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
