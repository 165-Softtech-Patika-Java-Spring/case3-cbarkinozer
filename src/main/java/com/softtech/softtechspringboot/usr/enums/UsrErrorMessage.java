package com.softtech.softtechspringboot.usr.enums;

import com.softtech.softtechspringboot.gen.enums.BaseErrorMessage;

public enum UsrErrorMessage implements BaseErrorMessage {

    USER_NOT_FOUND("User not found!"),
    USERNAME_EXISTS("Username of the user already exists!"),
    EMAIL_EXISTS("Email of the user already exists!"),
    PHONE_NUMBER_EXISTS("Phone number of the user already exists!"),
    ;

    private String message;
    UsrErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
