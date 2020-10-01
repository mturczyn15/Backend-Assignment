package com.assignment.notes.controller;

import com.assignment.notes.domain.NoteVersionDto;
import com.assignment.notes.service.NoteVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class NoteVersionController {

    @Autowired
    private NoteVersionService noteVersionService;

    @GetMapping( value = "/versions")
    public List<NoteVersionDto> getExemplars(@RequestParam Long note_Id) {
        return noteVersionService.getVersionsOfNoteById(note_Id);
    }

    @GetMapping(value = "/allversions")
    public List<NoteVersionDto> getNotes() {
        return noteVersionService.getNotes();
    }
}
