package com.sample.sample.controller;

import com.sample.sample.dto.UserDto;
import com.sample.sample.model.User;
import com.sample.sample.repository.UserRepository;
import com.sample.sample.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Data
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserService userService;

    @GetMapping("/all")
    public List<UserDto> getAllUsers(){
        List<UserDto> usersDto  = userService.getAllUsers();
        return usersDto;
    }

    @PostMapping("/add")
    public UserDto addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("users/{id}")
    public UserDto getUser(@PathVariable(value="id") String userId){
        return userService.getUser(userId);
    }

    @PutMapping("users/{id}")
    public UserDto updateUser(@PathVariable(value="id") String userId, @Valid @RequestBody User userDetails){
        return userService.updateUser(userId,userDetails);
    }

    @DeleteMapping("users/{id}")
    public UserDto deleteUser(@PathVariable(value="id") String userId){
        return userService.deleteUser(userId);
    }
}
