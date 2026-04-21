package com.PraktikumDB.deploy.controller;

import com.PraktikumDB.deploy.model.User;
import com.PraktikumDB.deploy.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestBody User request){
        return "user created succsessfully";
    }

    @GetMapping
    public List<User> getAllUser(){
        return  userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "user deleted successfully";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody User request) {
        userService.updateUser(id, request);
        return "user update successfully";
    }
}
