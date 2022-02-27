package com.softtech.softtechspringboot.cmt.enums;

import com.softtech.softtechspringboot.gen.enums.BaseErrorMessage;

public enum CmtErrorMessage implements BaseErrorMessage {

    COMMENT_NOT_FOUND("Comment not found!"),
    USER_HAS_NO_COMMENT("Queried user has no comment!"),
    PRODUCT_HAS_NO_COMMENT("Queried product has no comment!")
    ;

    private String message;

    CmtErrorMessage(String message) {
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

