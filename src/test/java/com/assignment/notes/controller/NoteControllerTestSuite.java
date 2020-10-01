package com.assignment.notes.controller;

import com.assignment.notes.domain.NoteDto;
import com.assignment.notes.service.NoteService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(NoteController.class)
public class NoteControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    @Test
    public void shouldFetchEmptyNotes() throws Exception {
        //Given
        List<NoteDto> notesDto = new ArrayList<>();
        when(noteService.getNotes()).thenReturn(notesDto);
        //When&Then
        mockMvc.perform(get("/v1/notes").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldFetchNotes() throws Exception {
        //Given
        List<NoteDto> notesDto = new ArrayList<>();
        notesDto.add(new NoteDto(1L, "note", "city", LocalDate.of(2020, 10,1), LocalDate.of(2020, 10,9)));
        when(noteService.getNotes()).thenReturn(notesDto);
        //When&Then
        mockMvc.perform(get("/v1/notes").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("note")))
                .andExpect(jsonPath("$[0].content", is("city")))
                .andExpect(jsonPath("[0].created", is("2020-10-01")))
                .andExpect(jsonPath("[0].modified", is("2020-10-09")));
    }


    @Test
    public void shouldFetchNote() throws Exception {
        //Given
        NoteDto noteDto = new NoteDto(1L, "note", "city", LocalDate.of(2020, 10,1), LocalDate.of(2020, 10,9));
        when(noteService.getNote(ArgumentMatchers.any(Long.class))).thenReturn(noteDto);
        //When&Then
        mockMvc.perform(get("/v1/notes/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("note")))
                .andExpect(jsonPath("$.content", is("city")));

    }

    @Test
    public void shouldDeleteNote() throws Exception {
        //Given
        NoteDto noteDto = new NoteDto(1L, "note", "city", LocalDate.of(2020, 10,1), LocalDate.of(2020, 10,9));
        when(noteService.create(noteDto)).thenReturn(noteDto);
        //When&Then
        mockMvc.perform(delete("/v1/notes/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCreateNote() throws Exception {
        //Given
        NoteDto noteDto = new NoteDto(1l, "note", "city", null, null);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(noteDto);
        when(noteService.create(noteDto)).thenReturn(noteDto);
        //When&Then
        mockMvc.perform(post("/v1/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());

    }

    @Test
    public void shouldUpdateNote() throws Exception {
        //Given
        NoteDto noteDto = new NoteDto(1L, "note", "city", null, null);
        NoteDto updatedNoteDto = new NoteDto(1L, "note", "city on the night", null, null);
        when(noteService.update(noteDto)).thenReturn(updatedNoteDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(noteDto);
        //When&Then
        mockMvc.perform(put("/v1/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("note")))
                .andExpect(jsonPath("$.content", is("city on the night")));
    }
}
