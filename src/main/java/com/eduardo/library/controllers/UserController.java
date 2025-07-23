package com.eduardo.library.controllers;

import com.eduardo.library.dtos.UserDTO;
import com.eduardo.library.models.UserModel;
import com.eduardo.library.services.UserService;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*" , maxAge = 3600)
@RequestMapping("/api/v1/library/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/new-user")
    public ResponseEntity<Object> newUser(@RequestBody @Valid UserDTO userDTO) {
        if(userService.existsByUserNickNameAndUserCpf(userDTO.getUserNickName(), userDTO.getUserCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);
        userModel.setInsertDateTime(LocalDateTime.now(ZoneId.of("UTC")));
        userModel.setUpdateDateTime(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body("User created" + userService.save(userModel));
    }

    @PutMapping("/att-user")
    public ResponseEntity<Object> updateUser(@RequestBody @Valid UserDTO userDTO) {
        if(!userService.existsByUserNickNameAndUserCpf(userDTO.getUserNickName(), userDTO.getUserCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User not found");
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);
        userModel.setUserPassword(userDTO.getUserPassword());
        userModel.setUserEmail(userDTO.getUserEmail());
        userModel.setUpdateDateTime(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.OK).body("User updated" + userService.save(userModel));
    }

    @GetMapping("/login-user")
    public ResponseEntity<Object> getUserByUserEmailAndPassword(@RequestBody @Valid UserDTO userDTO) {
        if(userService.getUserByUserEmailAndPassword(userDTO.getUserEmail(),userDTO.getUserPassword())){
            return ResponseEntity.status(HttpStatus.OK).body("User found" + userDTO.getUserEmail());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }


}
