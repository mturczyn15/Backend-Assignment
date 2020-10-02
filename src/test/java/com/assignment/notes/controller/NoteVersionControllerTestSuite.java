package com.assignment.notes.controller;

import com.assignment.notes.domain.Action;
import com.assignment.notes.domain.NoteVersionDto;
import com.assignment.notes.service.NoteVersionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(NoteVersionController.class)
public class NoteVersionControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteVersionService noteVersionService;

    @Test
    public void shouldFetchEmptyVersionsOfNote() throws Exception {
        //Given
        List<NoteVersionDto> notesDto = new ArrayList<>();
        when(noteVersionService.getVersionsOfNoteById(1L)).thenReturn(notesDto);
        //When&Then
        mockMvc.perform(get("/v1/versions").param("note_Id", "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldFetchNoteVersions() throws Exception {
        //Given
        List<NoteVersionDto> notesVersionDto = new ArrayList<>();
        notesVersionDto.add(new NoteVersionDto(1L,1L, "note", "city", LocalDate.of(2020, 10,1), null, Action.CREATE, 1));
        when(noteVersionService.getVersionsOfNoteById(1L)).thenReturn(notesVersionDto);
        //When&Then
        mockMvc.perform(get("/v1/versions").param("note_Id", "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("note")))
                .andExpect(jsonPath("$[0].content", is("city")))
                .andExpect(jsonPath("[0].created", is("2020-10-01")))
                .andExpect(jsonPath("[0].action", is("CREATE")))
                .andExpect(jsonPath("[0].version", is(1)))
        ;
    }
}
