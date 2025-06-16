package com.froyo.messages;

import java.io.Serializable;

public enum MessagePairTypeCode implements Serializable {

    INFO("I", "INFO"), //
    SUCCESS("S", "SUCCESS"), //
    WARNING("W", "WARNING"), //
    ERROR("E", "ERROR");

    private final String code;
    private final String description;

    MessagePairTypeCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "MessagePairTypeCode{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
