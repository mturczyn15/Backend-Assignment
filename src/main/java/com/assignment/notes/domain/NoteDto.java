package com.assignment.notes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDto {

    private Long id;
    @NotNull
    @Size(min = 3, message = "Title should have at least 3 character")
    private String title;
    @NotNull
    @Size(min = 3, message = "Title should have at least 3 character")
    private String content;
    private LocalDate created;
    private LocalDate modified;
}
