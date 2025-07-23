package com.eduardo.library.repositories;

import com.eduardo.library.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    boolean existsByUserNameAndUserCpf(String userEmail , String userCpf);

    boolean findByUserNickNameAndPassword(String userEmail , String password);

}
