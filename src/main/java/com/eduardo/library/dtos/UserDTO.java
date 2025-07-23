package com.eduardo.library.dtos;

import com.eduardo.library.enums.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    @NotBlank
    @Size(min = 1, max = 50)
    private String userName;

    @NotBlank
    @Size(min = 1, max = 50)
    private String userEmail;

    @NotBlank
    @Size(min = 1, max = 50)
    private String userCpf;

    @NotBlank
    @Size(min = 1, max = 50)
    private String userPassword;

    @NotBlank
    @Size(min = 1, max = 50)
    private String userNickName;

    @NotNull
    @Size(min = 1, max = 50)
    private RoleUser userRole;

}
