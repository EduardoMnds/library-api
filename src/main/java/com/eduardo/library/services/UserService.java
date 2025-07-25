package com.eduardo.library.services;

import com.eduardo.library.models.UserModel;
import com.eduardo.library.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Getter
@Setter
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public boolean existsByUserEmailOrUserCpf(String userEmail, String userCpf) {
        return userRepository.existsByUserEmailOrUserCpf(userEmail,userCpf);
    }


    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public boolean getUserByUserEmailAndPassword(String userEmail, String userPassword) {
        return userRepository.existsByUserEmailAndUserPassword(userEmail, userPassword);
    }

    public Optional<UserModel> findByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

}
