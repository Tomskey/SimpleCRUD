package com.example.TSNotes.TSNotes.controller;

import com.example.TSNotes.TSNotes.model.dto.EditNoteDto;
import com.example.TSNotes.TSNotes.model.dto.NoteDto;
import com.example.TSNotes.TSNotes.model.entity.NoteEntity;
import com.example.TSNotes.TSNotes.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/notes")
    public List<NoteDto> getAllNotes() {
        return noteService.findAll();
    }

    @PostMapping("/notes")
    public ResponseEntity<Void> createNote(@Valid @RequestBody EditNoteDto note) {
        noteService.createNote(note);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/notes/{title}")
    public NoteDto getNoteById(@PathVariable(value = "title") String title) {
        return noteService.getSingleNote(title);
    }


    @PutMapping("/notes/{title}")
    public ResponseEntity<Void> updateNote(@PathVariable(value = "title") String title, @Valid @RequestBody EditNoteDto noteDetails) {
        noteService.updateNote(title, noteDetails);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/notes/{title}")
    public ResponseEntity<Void> deleteNote(@PathVariable(value = "title") String title) {
        noteService.deleteNote(title);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
