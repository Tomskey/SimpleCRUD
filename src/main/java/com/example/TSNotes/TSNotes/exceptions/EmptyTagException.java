package com.example.TSNotes.TSNotes.exceptions;

import org.springframework.http.HttpStatus;

public class EmptyTagException extends ServiceException {
    public EmptyTagException() {
        super(HttpStatus.NOT_FOUND, "Tag is empty");
    }
}
