package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    //Injecting Userservice to call Userservice

    @GetMapping("/getUser")
    //public String getUser(){ //This return type String is not valid anymore, cuz we have to return a List.
        public List<UserDTO> getUser(){
        //return "Simple-Root";
        return userService.getAllUsers();
    }

    @PutMapping("/updateUser")
   // public String updateUser(){
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
        //return "User Updated!";

    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        //JSON Object type data concerted to Java Object type using RequestBody Annotation.
       // return "User Saved!";
        return userService.saveUser(userDTO);
        //We injected userService earlier. Here we take saveUser from userService and put userDTO into that.
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){
    //public String deleteUser(){
        //return "User Deleted!";
        return userService.deleteUser((userDTO));
    }

    @GetMapping("/getUserByUserId/{userID}")
    public UserDTO getUserByUserID(@PathVariable String userID){
        return userService.getUserByUserID(userID);
    }

    @GetMapping("/getUserByUserIdAddress/{userID}/{address")
    public UserDTO getUserByUserIDAddress(@PathVariable String userID, String address){
        return userService.getUserByUserIDAddress(userID, address);
    }

}
