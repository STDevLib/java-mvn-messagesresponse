package com.froyo.messages;
import com.froyo.messages.exceptions.ValidationConstraintRemote;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class AbstractResponse implements Serializable {

    private static final long serialVersionUID = -2762361600162949130L;

    private final List<MessagePair> messagePairList = new ArrayList<>();

    public AbstractResponse() {
    }

    public void addMessagePair(final MessagePair messagePair) {
        Objects.requireNonNull(messagePair, "messagePair is marked non-null but is null");
        messagePairList.add(messagePair);
    }

    public List<MessagePair> getMessagePairList() {
        return Collections.unmodifiableList(this.messagePairList);
    }

    public void hasValidationConstraint(){

        List<Set<ConstraintViolation<MessagePair>>> listOfConstraintsFound =
                new ArrayList<>();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        messagePairList.forEach(v -> {
            Set<ConstraintViolation<MessagePair>> violations = validator.validate(v);
            if(!violations.isEmpty()){
                listOfConstraintsFound.add(violations);
            }
        });

        if(!listOfConstraintsFound.isEmpty()){
            throw new ValidationConstraintRemote(listOfConstraintsFound);
        }

    }

    public Boolean has(final MessagePairTypeCode messagePairTypeCode) {
        Objects.requireNonNull(messagePairTypeCode, "messagePairTypeCode is marked non-null but is null");
        return messagePairList.stream()
                .anyMatch(s -> messagePairTypeCode.equals(s.getMessagePairTypeCode()));
    }

    public List<MessagePair> fetchMessagePair(final MessagePairTypeCode messagePairTypeCode) {
        Objects.requireNonNull(messagePairTypeCode, "messagePairTypeCode is marked non-null but is null");
        return messagePairList.stream()
                .filter(s -> messagePairTypeCode.equals(s.getMessagePairTypeCode()))
                .collect(Collectors.toList());
    }

}
