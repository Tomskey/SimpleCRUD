package com.example.TSNotes.TSNotes.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Document(collection = "notes")
public class NoteEntity implements Serializable {
    @Id
    private String id;
    @NotBlank
    @Indexed(unique=true)
    private String title;
    @NotBlank
    private String content;
    private String createdAt;
    private String updatedAt;
    private Set<String> tags;

    public void addTag(String tag){
        tags.add(tag);
    }



}
