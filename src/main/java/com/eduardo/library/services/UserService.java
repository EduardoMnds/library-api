package com.eduardo.library.services;

import com.eduardo.library.models.UserModel;
import com.eduardo.library.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserService {

    private UserRepository userRepository;

    public boolean existsByUserNickNameAndUserCpf(String getUserNickName, String userCpf) {
        return userRepository.existsByUserNameAndUserCpf(getUserNickName, userCpf);
    }

    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public boolean getUserByUserEmailAndPassword(String userEmail, String password) {
        return userRepository.findByUserNickNameAndPassword(userEmail, password);
    }

}
