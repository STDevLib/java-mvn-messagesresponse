package com.froyo.messages.codes;

import com.froyo.messages.MessagePairTypeCode;

import java.io.Serializable;

import static com.froyo.messages.MessagePairTypeCode.ERROR;
import static com.froyo.messages.MessagePairTypeCode.SUCCESS;

public enum FilesMessageCode implements Serializable {

    //1001 General
    FILE_1001("FILE-1001", "ERROR", ERROR), //
    FILE_1002("FILE-1002", "SUCCESS", SUCCESS), //

    //1101
    FILE_1101("FILE-1101", "Error upload photo", ERROR), //
    FILE_1102("FILE-1102", "Success to save album", SUCCESS);

    private final String code;
    private final String description;
    private final MessagePairTypeCode messagePairTypeCode;

    FilesMessageCode(String code, String description, MessagePairTypeCode messagePairTypeCode) {
        this.code = code;
        this.description = description;
        this.messagePairTypeCode = messagePairTypeCode;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public MessagePairTypeCode getMessagePairTypeCode() {
        return messagePairTypeCode;
    }

}
