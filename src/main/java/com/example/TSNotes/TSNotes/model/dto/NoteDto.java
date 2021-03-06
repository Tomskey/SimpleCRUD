package com.example.TSNotes.TSNotes.model.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Setter
@Getter
public class NoteDto {

    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private String createdAt;
    private String updatedAt;
    private Set<String> tags;

    public void addTag(String tag){
        tags.add(tag);
    }
    public void deleteTag(String tag){
        tags.remove(tag);
    }

}
