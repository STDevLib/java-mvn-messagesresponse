package com.froyo.messages.exceptions;

import com.froyo.messages.MessagePair;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.ConstraintViolation;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ValidationConstraintRemote extends RuntimeException {

    private final String exceptionMessage;
    private final List<Set<ConstraintViolation<MessagePair>>> listOfConstraintsFound;

    private ValidationConstraintRemote(){
        throw new AssertionError();
    }

    public ValidationConstraintRemote(@NonNull List<Set<ConstraintViolation<MessagePair>>> listOfConstraintsFound){
        super("Please check the constraints for <<MessagePair>> class");
        this.exceptionMessage = "Please check the constraints for <<MessagePair>> class";
        this.listOfConstraintsFound = Collections.unmodifiableList(listOfConstraintsFound);
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public List<Set<ConstraintViolation<MessagePair>>> getListOfConstraintsFound() {
        return this.listOfConstraintsFound;
    }

}
