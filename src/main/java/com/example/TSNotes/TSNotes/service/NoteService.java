package com.example.TSNotes.TSNotes.service;

import com.example.TSNotes.TSNotes.exceptions.DuplicateTitleException;
import com.example.TSNotes.TSNotes.exceptions.NoteNotFoundException;
import com.example.TSNotes.TSNotes.model.dto.CreateNoteDto;
import com.example.TSNotes.TSNotes.model.dto.NoteDto;
import com.example.TSNotes.TSNotes.model.entity.NoteEntity;
import com.example.TSNotes.TSNotes.repository.NoteRepository;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final ModelMapper modelMapper;

    public List<NoteDto> findAll() {
        List<NoteEntity> list = noteRepository.findAll();

        return modelMapper.map(list, new TypeToken<List<NoteDto>>() {}.getType());
    }

    public void createNote(CreateNoteDto note) {

        NoteEntity noteEntity = modelMapper.map(note, NoteEntity.class);
        String currentTime = Instant.now().toString();
        noteEntity.setCreatedAt(currentTime);
        noteEntity.setUpdatedAt(currentTime);
        try{noteRepository.save(noteEntity);}
        catch (DuplicateKeyException ex){
            throw new DuplicateTitleException();
        }

    }

    public NoteDto getSingleNote(String id) {
        NoteEntity noteEntity = noteRepository.findByTitle(id).orElseThrow(NoteNotFoundException::new);

        return modelMapper.map(noteEntity, NoteDto.class);
    }

    public void deleteNote(String id) {
        noteRepository.deleteById(id);
    }

    public void updateNote(String id, NoteEntity noteDetails) {
        NoteEntity note = noteRepository.findById(id).orElseThrow(NoteNotFoundException::new);
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        NoteEntity updatedNote = noteRepository.save(note);

    }


}
