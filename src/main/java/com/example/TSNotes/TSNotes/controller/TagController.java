package com.example.TSNotes.TSNotes.controller;

import com.example.TSNotes.TSNotes.model.dto.TagDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.TSNotes.TSNotes.service.NoteService;

import javax.swing.text.html.HTML;
import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class TagController {

    private final NoteService noteService;

    @PostMapping("/notes/{title}/tags")
    public ResponseEntity<Void> addTag(@PathVariable String title, @Valid @RequestBody TagDto tagDto) {
        noteService.addTag(title, tagDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/notes/{title}/tags")
    public ResponseEntity<Void> deleteTag(@PathVariable String title, @Valid @RequestBody TagDto tagDto) {
        noteService.deleteTag(title, tagDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
