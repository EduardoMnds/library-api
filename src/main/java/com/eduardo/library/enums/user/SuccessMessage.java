package com.eduardo.library.enums.user;

public enum SuccessMessage {

    USER_FOUND("User found"),
    USER_UPDATED("User updated"),
    USER_CREATED("User created successfully");

    private final String message;

    SuccessMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
