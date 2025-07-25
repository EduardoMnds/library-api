package com.eduardo.library.repositories;

import com.eduardo.library.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    boolean existsByUserEmailOrUserCpf(String userEmail, String userCpf);

    boolean existsByUserEmailAndUserPassword(String userEmail , String userPassword);

    Optional<UserModel> findByUserEmail(String userEmail);
}
