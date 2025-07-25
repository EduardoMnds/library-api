package com.eduardo.library.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponseUserDTO {

    private String message;
    private String userEmail;
    private String userNickName;

}