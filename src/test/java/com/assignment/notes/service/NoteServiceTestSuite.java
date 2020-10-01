package com.assignment.notes.service;

import com.assignment.notes.domain.Note;
import com.assignment.notes.domain.NoteDto;
import com.assignment.notes.exception.ResourceNotFoundException;
import com.assignment.notes.mapper.NoteMapper;
import com.assignment.notes.repository.NoteRepository;
import com.assignment.notes.repository.NoteVersionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTestSuite {

    @InjectMocks
    private NoteService noteService;

    @Mock
    private NoteRepository noteRepository;

    @Mock
    private NoteMapper noteMapper;

    @Mock
    private NoteVersionRepository noteVersionRepository;

    @Test
    public void testGetNotes() {
        //Given
        List<Note> list = new ArrayList<>();
        list.add(new Note(1L, "task", "city", LocalDate.of(2020, 10,1), LocalDate.of(2020, 10,9)));
        List<NoteDto> listDto = new ArrayList<>();
        listDto.add(new NoteDto(1L, "task", "city", LocalDate.of(2020, 10,1), LocalDate.of(2020, 10,9)));
        when(noteMapper.mapToDtoList(list)).thenReturn(listDto);
        when(noteRepository.findAll()).thenReturn(list);
        //When
        List<NoteDto> retrievedList = noteService.getNotes();
        //Then
        assertEquals(1, retrievedList.size());
    }

    @Test
    public void testGetNote() {
        //Given
        Optional<Note> note = Optional.of(new Note(1L, "task", "city", LocalDate.of(2020, 10,1), LocalDate.of(2020, 10,9)));
        Long id = note.get().getId();
        NoteDto noteDto = new NoteDto(1L, "task", "city", LocalDate.of(2020, 10,1), LocalDate.of(2020, 10,9));
        when(noteRepository.findById(ArgumentMatchers.any(Long.class))).thenReturn(note);
        when(noteMapper.mapToDto(note.orElseThrow(() -> new ResourceNotFoundException("There is no note with id: " + id)))).thenReturn(noteDto);
        //When
        NoteDto retrievedNoteDto = noteService.getNote(id);
        //Then
        assertEquals(1, retrievedNoteDto.getId());
    }

    @Test
    public void testCreate() {
        //Given
        Note note = new Note("task", "city");
        NoteDto noteDto = new NoteDto(1L, "task", "city", LocalDate.of(2020, 10,1), LocalDate.of(2020, 10,9));
        when(noteRepository.save(note)).thenReturn(note);
        when(noteMapper.mapToDto(note)).thenReturn(noteDto);
        //When
        NoteDto createdNote = noteService.create(noteDto);
        //Then
        assertEquals(1, createdNote.getId());
    }

    @Test
    public void testUpdate() {
        //Given
        Optional<Note> note = Optional.of(new Note(1L, "task", "city", LocalDate.of(2020, 10,1), LocalDate.of(2020, 10,9)));
        Note note1 = new Note(1L, "task", "city", LocalDate.of(2020, 10,1), LocalDate.of(2020, 10,9));
        NoteDto noteDto = new NoteDto(1L, "task", "city", LocalDate.of(2020, 10,1), LocalDate.of(2020, 10,9));
        when(noteMapper.map(noteDto)).thenReturn(note1);
        when(noteRepository.save(note1)).thenReturn(note1);
        when(noteMapper.mapToDto(note1)).thenReturn(noteDto);
        when(noteRepository.findById(ArgumentMatchers.any(Long.class))).thenReturn(note);
        //When
        NoteDto updatedNote = noteService.update(noteDto);
        //Then
        assertEquals(1, updatedNote.getId());
    }

    @Test
    public void testDelete() {
        //Given
        Optional<Note> note = Optional.of(new Note(1L, "task", "city", LocalDate.of(2020, 10,1), LocalDate.of(2020, 10,9)));
        Note note1 = new Note(1L, "task", "city", LocalDate.of(2020, 10,1), LocalDate.of(2020, 10,9));
        when(noteRepository.findById(ArgumentMatchers.any(Long.class))).thenReturn(note);
        //When
        noteService.delete(note1.getId());
        //Then
        verify(noteRepository, times(1)).deleteById(note1.getId());
    }

}

