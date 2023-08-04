package org.ac.cst8277.kwok_szeman.Controller;


import org.ac.cst8277.kwok_szeman.db1.repo.UserRepo;
import org.ac.cst8277.kwok_szeman.db2.entity.Message;
import org.ac.cst8277.kwok_szeman.db2.repo.MessageRepo;
import org.ac.cst8277.kwok_szeman.dto.AllRoles;
import org.ac.cst8277.kwok_szeman.db1.entity.User;
import org.ac.cst8277.kwok_szeman.dto.MsgFromSubscriber;
import org.ac.cst8277.kwok_szeman.dto.MsgFromUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private WebClient webClient;

//    get all the users
    @GetMapping(value="/users")
    public List<User> getAllUsers(){

        return userRepo.findAll();
    }

//    get all the roles with user name
    @GetMapping(value="/getAllRoles")
    public List<AllRoles> getAllRoles(){
        return userRepo.getAllRoles();
    }

//  add a user
    @PostMapping(value="/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "User added.";
    }

//    update a user
    @RequestMapping(value="/update/{userID}")
    public String updateUser(@PathVariable long userID, @RequestBody User user){
        User updatedUser = userRepo.findById(userID).get();
        updatedUser.setUsername(user.getUsername());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        return "User updated.";
    }

    @GetMapping(value="/messages")
    public List<Message> getAllMessages(){
        return messageRepo.findAll();
    }

    @GetMapping(value="/msgFromProducer")
    public List<MsgFromUser> getMsgById(){
        return messageRepo.getMsgFromProducer();
    }

    @GetMapping(value="/subscriber")
    public List<MsgFromSubscriber> getMsgFromSubscriber(){
        return messageRepo.getSubscriber();
    }
}
