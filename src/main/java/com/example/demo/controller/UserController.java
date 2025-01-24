package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    //Injecting Userservice to call Userservice

    @GetMapping("/getUser")
    public String getUser(){
        return "Simple-Root";
    }

    @PutMapping("/updateUser")
    public String updateUser(){
        return "User Updated!";
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        //JSON Object type data concerted to Java Object type using RequestBody Annotation.
       // return "User Saved!";
        return userService.saveUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(){
        return "User Deleted!";
    }
}
