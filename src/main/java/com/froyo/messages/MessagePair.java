package com.froyo.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@Getter
public class MessagePair implements Serializable {

    private static final long serialVersionUID = 2734364864701881278L;

    private final String code;
    @NotBlank
    private final String description;
    @NotNull
    private final MessagePairTypeCode messagePairTypeCode;

}
