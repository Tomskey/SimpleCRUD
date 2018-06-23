package com.example.TSNotes.TSNotes.service;

import com.example.TSNotes.TSNotes.exceptions.DuplicateTitleException;
import com.example.TSNotes.TSNotes.exceptions.NoteNotFoundException;
import com.example.TSNotes.TSNotes.model.dto.EditNoteDto;
import com.example.TSNotes.TSNotes.model.dto.NoteDto;
import com.example.TSNotes.TSNotes.model.dto.TagDto;
import com.example.TSNotes.TSNotes.model.entity.NoteEntity;
import com.example.TSNotes.TSNotes.repository.NoteRepository;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final ModelMapper modelMapper;

    public List<NoteDto> findAll() {
        List<NoteEntity> list = noteRepository.findAll();

        return modelMapper.map(list, new TypeToken<List<NoteDto>>() {}.getType());
    }

    public void createNote(EditNoteDto note) {

        NoteEntity noteEntity = modelMapper.map(note, NoteEntity.class);
        String currentTime = Instant.now().toString();
        noteEntity.setCreatedAt(currentTime);
        noteEntity.setUpdatedAt(currentTime);
        noteEntity.setTags(new HashSet<>());
        try{
            noteRepository.save(noteEntity);
        }
        catch (DuplicateKeyException ex){
            throw new DuplicateTitleException();
        }

    }

    public NoteDto getSingleNote(String title) {
        NoteEntity noteEntity = noteRepository.findByTitle(title).orElseThrow(NoteNotFoundException::new);

        return modelMapper.map(noteEntity, NoteDto.class);
    }

    public void deleteNote(String title) {
        noteRepository.deleteByTitle(title);
    }

    public void updateNote(String title, EditNoteDto noteDetails) {
        NoteEntity note = noteRepository.findByTitle(title).orElseThrow(NoteNotFoundException::new);
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        note.setUpdatedAt(Instant.now().toString());
        try{
            noteRepository.save(note);
        }
        catch (DuplicateKeyException ex){
            throw new DuplicateTitleException();
        }

    }

    public void addTag(String title,TagDto tagDto){
        NoteEntity note=noteRepository.findByTitle(title).orElseThrow(NoteNotFoundException::new);
        note.addTag(tagDto.getTag());

    }


}
