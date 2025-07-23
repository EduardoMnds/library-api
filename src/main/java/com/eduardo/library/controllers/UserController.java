package com.eduardo.library.controllers;

import com.eduardo.library.dtos.UserDTO;
import com.eduardo.library.models.UserModel;
import com.eduardo.library.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*" , maxAge = 3600)
@RequestMapping("/api/v1/library/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/new-user")
    public ResponseEntity<Object> newUser(@RequestBody @Valid UserDTO userDTO) {


        return null;
    }
}
