package com.eduardo.library.models;

import com.eduardo.library.enums.user.RoleUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EMG_USER")
public class UserModel {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_NICKNAME")
    private String userNickName;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "USER_CPF")
    private String userCpf;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "USER_ROLE")
    @Enumerated(EnumType.STRING)
    private RoleUser userRole;

    @Column(name = "INSERT_DATETIME")
    private LocalDateTime insertDateTime;

    @Column(name = "UPDATE_DATETIME")
    private LocalDateTime updateDateTime;

}
