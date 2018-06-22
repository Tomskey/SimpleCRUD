package com.example.TSNotes.TSNotes.exceptions;

import org.springframework.http.HttpStatus;

public class DuplicateTitleException extends ServiceException {

    public DuplicateTitleException() {
        super(HttpStatus.CONFLICT, "Note with that title already exists");
    }
}
