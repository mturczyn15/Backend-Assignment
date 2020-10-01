package com.assignment.notes.service;

import com.assignment.notes.domain.NoteVersion;
import com.assignment.notes.domain.NoteVersionDto;
import com.assignment.notes.mapper.NoteVersionMapper;
import com.assignment.notes.repository.NoteVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteVersionService {

    @Autowired
    private NoteVersionRepository noteVersionRepository;
    @Autowired
    private NoteVersionMapper noteVersionMapper;

    public List<NoteVersionDto> getVersionsOfNoteById(Long noteId) {
        List<NoteVersion> list = noteVersionRepository.findByNoteId(noteId);
        return noteVersionMapper.mapToDtoList(list);
    }
}
