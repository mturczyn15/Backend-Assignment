package com.assignment.notes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@Table(name = "NOTE_VERSIONS")
public class NoteVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VERSION_ID")
    private Long id;

    @Column(name = "NOTE_ID")
    private Long noteId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "CREATED")
    private LocalDate created;

    @Column(name = "MODIFIED")
    private LocalDate modified;

    @Enumerated(EnumType.STRING)
    @Column(name = "ACTION")
    private Action action;

    @Column(name = "VERSION")
    private int version;

    public NoteVersion(Note note, int version, Action action) {
        this.noteId = note.getId();
        this.title = note.getTitle();
        this.content = note.getContent();
        this.created = note.getCreated();
        this.modified = note.getModified();
        this.version = version;
        this.action = action;
    }
}
