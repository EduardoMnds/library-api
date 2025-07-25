package com.eduardo.library.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SuccessResponseUserDTO {

    private String message;
    private String userEmail;
    private String userNickName;

}
