package com.froyo.messages.exceptions;
import com.froyo.messages.MessagePair;

import javax.validation.ConstraintViolation;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ValidationConstraintRemote extends RuntimeException {

    private final String exceptionMessage;
    private final List<Set<ConstraintViolation<MessagePair>>> listOfConstraintsFound;

    private ValidationConstraintRemote(){
        throw new AssertionError();
    }

    public ValidationConstraintRemote(List<Set<ConstraintViolation<MessagePair>>> listOfConstraintsFound){
        Objects.requireNonNull(listOfConstraintsFound, "listOfConstraintsFound is marked non-null but is null");
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
