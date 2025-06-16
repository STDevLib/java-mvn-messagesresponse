package com.froyo.messages;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class MessagePair implements Serializable {

    private static final long serialVersionUID = 2734364864701881278L;

    private final String code;
    @NotBlank
    private final String description;
    @NotNull
    private final MessagePairTypeCode messagePairTypeCode;

    public MessagePair(String code, String description, MessagePairTypeCode messagePairTypeCode) {
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
