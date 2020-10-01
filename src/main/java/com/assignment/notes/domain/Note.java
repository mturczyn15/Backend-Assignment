package com.assignment.notes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@Table(name = "NOTES")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "CREATED")
    private LocalDate created;

    @Column(name = "MODIFIED")
    private LocalDate modified;

    public Note( @NotNull String title, @NotNull String content) {
        this.title = title;
        this.content = content;
        this.created = LocalDate.now();
    }
}
