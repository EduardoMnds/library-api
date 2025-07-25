package com.eduardo.library.enums.user;

public enum ErrorMessage {

    USER_NOT_FOUND("User not found"),
    USER_ALREADY_EXISTS("User already exists(CPF or EMAIL"),
    USER_EMAIL_ALREADY_EXISTS("User Email already exists"),
    USER_CREDENTIALS_INVALID("Password or Email is incorrect"),;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
