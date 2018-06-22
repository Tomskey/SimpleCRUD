package com.example.TSNotes.TSNotes.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Setter
@Getter
public class NoteDto {

    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private String createdAt;
    private String updatedAt;
}
