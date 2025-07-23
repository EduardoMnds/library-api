package com.eduardo.library.dtos;

import com.eduardo.library.enums.RoleUser;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @NotNull
    @Size(min = 1, max = 50)
    private RoleUser userRole;

}
