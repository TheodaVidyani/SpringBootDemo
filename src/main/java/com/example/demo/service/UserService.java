package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
