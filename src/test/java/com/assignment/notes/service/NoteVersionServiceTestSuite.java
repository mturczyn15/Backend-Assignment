package com.assignment.notes.service;

import com.assignment.notes.domain.Action;
import com.assignment.notes.domain.NoteVersion;
import com.assignment.notes.domain.NoteVersionDto;
import com.assignment.notes.mapper.NoteVersionMapper;
import com.assignment.notes.repository.NoteVersionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NoteVersionServiceTestSuite {

    @InjectMocks
    private NoteVersionService noteVersionService;

    @Mock
    private NoteVersionRepository noteVersionRepository;

    @Mock
    private NoteVersionMapper noteVersionMapper;

    @Test
    public void testGetVersionsOfNoteById() {
        //Given
        List<NoteVersion> list = new ArrayList<>();
        list.add(new NoteVersion(1L, 1L, "Note1", "Eat breakfast", LocalDate.now(), null, Action.CREATE, 1));
        list.add(new NoteVersion(2L, 2L, "Note1", "Eat breakfast", LocalDate.now(), null, Action.CREATE, 1));
        List<NoteVersionDto> listDto = new ArrayList<>();
        listDto.add(new NoteVersionDto(1L, 1L, "Note1", "Eat breakfast", LocalDate.now(), null, Action.CREATE, 1));
        when(noteVersionMapper.mapToDtoList(list)).thenReturn(listDto);
        when(noteVersionRepository.findByNoteId(1L)).thenReturn(list);
        //When
        List<NoteVersionDto> retrievedList = noteVersionService.getVersionsOfNoteById(1L);
        //Then
        assertEquals(1, retrievedList.size());
    }
}

