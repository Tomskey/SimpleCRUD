package com.example.TSNotes.TSNotes.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NoteNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFound(NoteNotFoundException ex) {
        return new ResponseEntity<>(ex.formattedResponse(), ex.getStatus());
    }

    @ExceptionHandler({DuplicateTitleException.class})
    public ResponseEntity<Object> handleDuplicateTitle(DuplicateTitleException ex) {
        return new ResponseEntity<>(ex.formattedResponse(), ex.getStatus());
    }

}
