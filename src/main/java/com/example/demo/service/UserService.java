package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
//Transaction Annotation to handle transactions.


public class UserService {
    @Autowired
    private ModelMapper modelMapper;
    //The injected ModelMapper at DemoApplication was brought here and imported.

    @Autowired
    //Injecting user repository.
    private UserRepo userRepo;
    //Public method with return type string
    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        //Here we mapped/pass User DTO and User class of Entity. If not we cannot save data at the server, which we get/receive from DTO.
        //userDTO object was passed to User Entity using modelMapper.map method.
        return userDTO;
    }

    //Get All - User Fetching (We only have to write code in controller and service., cuz we have already written codes in DTO and Entity.)
    public List<UserDTO> getAllUsers(){
// Why Used List Interface? - Cuz we do a get all.
        List<User>userList=userRepo.findAll(); //FindAll is an inbuilt method. We put all the data that come to the method, to a List because we have to return them. Data comes in 'User' type.
    return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    //Update Method
    public UserDTO updateUser(UserDTO userDTO){ //After updating we are going to return the result. So we are writing UserDTO.
        userRepo.save(modelMapper.map(userDTO, User.class)); //We do not have a seperate update method. So we use save method.
        return userDTO;
        }
    //Delete method
    public boolean deleteUser(UserDTO userDTO){ //Use boolean because delete? or not?
        userRepo.delete(modelMapper.map(userDTO, User.class)); //User.class is the type of the entity.
        return true; //if deleted, return true boolean value.
    }

    //Pass userID throught postman, so it will send all user details.
    //select * from user where id =2

    public UserDTO getUserByUserID(String userID){
        User user=userRepo.getUserByUserID(userID);
        return modelMapper.map(user, UserDTO.class);
    }
    //Pass user Id and address, receive user details
    //select * from user where id=2 and address="Kandy"

    public UserDTO getUserByUserIDAddress(String userId, String address){
        User user=userRepo.getUserByUserIDAddress(userId, address);
        return modelMapper.map(user, UserDTO.class);
    }
}

//
