package com.assignment.notes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class NoteVersionDto {

    private Long id;
    private Long noteId;
    private String title;
    private String content;
    private LocalDate created;
    private LocalDate modified;
    private Action action;
    private int version;
}
