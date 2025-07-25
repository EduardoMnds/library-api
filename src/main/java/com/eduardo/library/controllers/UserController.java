package com.eduardo.library.controllers;

import com.eduardo.library.dtos.UserDTO;
import com.eduardo.library.enums.user.ErrorMessage;
import com.eduardo.library.enums.user.SuccessMessage;
import com.eduardo.library.models.UserModel;
import com.eduardo.library.responses.ErrorResponseUserDTO;
import com.eduardo.library.responses.SuccessResponseUserDTO;
import com.eduardo.library.services.UserService;
import javax.validation.Valid;

import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*" , maxAge = 3600)
@RequestMapping("/api/v1/library/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Testado
    @PostMapping("/new-user")
    public ResponseEntity<Object> newUser(@RequestBody @Valid UserDTO userDTO) {
        if(userService.existsByUserEmailOrUserCpf(userDTO.getUserEmail(),userDTO.getUserCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponseUserDTO(ErrorMessage.USER_ALREADY_EXISTS.getMessage(),userDTO.getUserEmail(),userDTO.getUserNickName()));
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);
        userModel.setInsertDateTime(LocalDateTime.now(ZoneId.of("UTC")));
        userModel.setUpdateDateTime(LocalDateTime.now(ZoneId.of("UTC")));
        userService.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponseUserDTO(SuccessMessage.USER_CREATED.getMessage(),userDTO.getUserEmail(),userDTO.getUserNickName()));
    }

    //Testado
    @PutMapping("/att-user/{userEmail}")
    public ResponseEntity<Object> updateUser(@PathVariable (value = "userEmail") String userEmail, @RequestBody @Valid UserDTO userDTO) {
        Optional<UserModel> userModelOptional = userService.findByUserEmail(userEmail);

        if(!userModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseUserDTO(ErrorMessage.USER_NOT_FOUND.getMessage(),userEmail,userDTO.getUserNickName()));
        }

        UserModel userModel =  userModelOptional.get();
        BeanUtils.copyProperties(userDTO, userModel);
        userModel.setUserPassword(userDTO.getUserPassword());
        userModel.setUserEmail(userDTO.getUserEmail());
        userModel.setUpdateDateTime(LocalDateTime.now(ZoneId.of("UTC")));
        if (userService.findByUserEmail(userDTO.getUserEmail()).stream().noneMatch(u -> u.getUserEmail().equals(userDTO.getUserEmail()))) {
            userService.save(userModel);
            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponseUserDTO(SuccessMessage.USER_UPDATED.getMessage(),userDTO.getUserEmail(),userDTO.getUserNickName()));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponseUserDTO(ErrorMessage.USER_EMAIL_ALREADY_EXISTS.getMessage(),userDTO.getUserEmail(),userDTO.getUserNickName()));
        }

    }
    //Testado
    @GetMapping("/login-user")
    public ResponseEntity<Object> getUserByUserEmailAndPassword(@RequestBody @Valid UserDTO userDTO) {
        if(userService.getUserByUserEmailAndPassword(userDTO.getUserEmail(),userDTO.getUserPassword())){
            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponseUserDTO(SuccessMessage.USER_FOUND.getMessage(),userDTO.getUserEmail(),userDTO.getUserNickName()) );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseUserDTO(ErrorMessage.USER_NOT_FOUND.getMessage(),userDTO.getUserEmail(), userDTO.getUserNickName()));
    }


}
