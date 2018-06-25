package com.example.TSNotes.TSNotes.repository;

import com.example.TSNotes.TSNotes.model.entity.NoteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;


public interface NoteRepository extends MongoRepository<NoteEntity, String> {
    Optional<NoteEntity> findByTitle(String title);
    Optional<NoteEntity> deleteByTitle(String title);
}
