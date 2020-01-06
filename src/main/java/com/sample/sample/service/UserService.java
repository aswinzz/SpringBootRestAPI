package com.sample.sample.service;

import com.sample.sample.dto.UserDto;
import com.sample.sample.model.User;
import com.sample.sample.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<>();
        users.forEach((user)->{
            UserDto userDto = new UserDto().setName(user.getName()).setEmail(user.getEmail());
            usersDto.add(userDto);
        });
        return usersDto;
    }

    public UserDto addUser(User data){
        User user = userRepository.save(data);
        UserDto userDto = new UserDto().setEmail(user.getEmail()).setName(user.getName());
        return userDto;
    }

    public UserDto getUser(String userId){
        User user = userRepository.findById(userId).orElse(null);
        UserDto userDto = new UserDto().setEmail(user.getEmail()).setName(user.getName());
        return userDto;
    }

    public UserDto updateUser(String userId,User userDetails){
        User user = userRepository.findById(userId).orElse(null);
        if(user!=null){
            user.setEmail(userDetails.getEmail());
            user.setName(userDetails.getName());
        }
        user = userRepository.save(user);
        UserDto userDto = new UserDto().setName(user.getName()).setEmail(user.getEmail());
        return userDto;
    }

    public UserDto deleteUser(String userId){
        User user = userRepository.findById(userId).orElse(null);
        userRepository.delete(user);
        UserDto userDto = new UserDto().setEmail(user.getEmail()).setName(user.getName());
        return userDto;
    }
}
