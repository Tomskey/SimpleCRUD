package com.example.TSNotes.TSNotes.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
public class TagDto {
    @NotBlank
    private String tag;
}
