package com.example.TSNotes.TSNotes.exceptions;

import org.springframework.http.HttpStatus;

public class NoteNotFoundException extends ServiceException {
    public NoteNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Note not found");
    }
}
