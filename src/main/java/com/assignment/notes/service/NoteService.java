package com.assignment.notes.service;

import com.assignment.notes.domain.Note;
import com.assignment.notes.domain.NoteDto;
import com.assignment.notes.exception.ResourceNotFoundException;
import com.assignment.notes.mapper.NoteMapper;
import com.assignment.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteMapper noteMapper;

    public NoteDto create(NoteDto noteDto) {

        Note note = new Note( noteDto.getTitle(), noteDto.getContent());
        return noteMapper.mapToDto(noteRepository.save(note));
    }

    public List<NoteDto> getNotes() {
        return noteMapper.mapToDtoList(noteRepository.findAll());
    }

    public NoteDto getNote(final Long id) {
        Optional<Note> note = noteRepository.findById(id);
        return noteMapper.mapToDto(note.orElseThrow(() -> new ResourceNotFoundException("There is no note with id: " + id)));
    }

    public NoteDto update(NoteDto noteDto) {

        Note oldNote = noteRepository.findById(noteDto.getId()).orElseThrow(() -> new ResourceNotFoundException("There is no note with id: " + noteDto.getId()));
        Note newNote = noteMapper.map(noteDto);
        newNote.setCreated(oldNote.getCreated());
        newNote.setModified(LocalDate.now());
        return noteMapper.mapToDto(noteRepository.save(newNote));
    }

    public void delete(final Long id) {
        noteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There is no note with id: " + id));
        noteRepository.deleteById(id);
    }


}
