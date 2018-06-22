package com.example.TSNotes.TSNotes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class EmptyFieldException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public EmptyFieldException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s have no content %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
