package com.assignment.notes.controller;

import com.assignment.notes.domain.NoteDto;
import com.assignment.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping(value = "/notes")
    public List<NoteDto> getNotes() {
        return noteService.getNotes();
    }

    @PostMapping(value = "/notes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNote(@Valid @RequestBody NoteDto noteDto) {
        noteService.create(noteDto);
    }

    @GetMapping(value = "/notes/{noteId}")
    public NoteDto getNote(@PathVariable("noteId") Long noteId) {
        return noteService.getNote(noteId);
    }

    @PutMapping(value = "/notes")
    public NoteDto updateNote(@Valid @RequestBody NoteDto noteDto) {
        return noteService.update(noteDto);
    }

    @DeleteMapping( value = "/notes/{noteId}")
    public void deleteNote(@PathVariable("noteId") Long noteId) {
        noteService.delete(noteId);
    }
}
