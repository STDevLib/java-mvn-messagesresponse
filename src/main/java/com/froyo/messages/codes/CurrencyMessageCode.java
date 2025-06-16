package com.froyo.messages.codes;

import com.froyo.messages.MessagePairTypeCode;

import java.io.Serializable;

import static com.froyo.messages.MessagePairTypeCode.ERROR;
import static com.froyo.messages.MessagePairTypeCode.SUCCESS;

public enum CurrencyMessageCode implements Serializable {

    //1001 General
    CY_1001("CY-1001", "ERROR", ERROR), //
    CY_1002("CY-1002", "SUCCESS", SUCCESS), //

    //1101
    CY_1101("CY-1101", "Error when try to save currency", ERROR), //
    CY_1102("CY-1102", "Save currency successfully", SUCCESS);

    private final String code;
    private final String description;
    private final MessagePairTypeCode messagePairTypeCode;

    CurrencyMessageCode(String code, String description, MessagePairTypeCode messagePairTypeCode) {
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
