package com.assignment.notes.repository;

import com.assignment.notes.domain.Note;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteRepositoryTestSuite {

    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void testSaveNote() {

        //Given
        Note note = new Note("Note1", "Eat breakfast");
        //When
        Note save = noteRepository.save(note);
        Long id = save.getId();
        //Then
        assertNotEquals((Object) 0L, id);
        assertEquals("Note1", save.getTitle());
        assertEquals("Eat breakfast", save.getContent());
        assertEquals(LocalDate.now(), save.getCreated());
        assertNull(save.getModified());
        //CleanUp
        noteRepository.deleteById(id);

    }

    @Test
    public void testDeleteNote() {

        //Given
        Note note = new Note("Note1", "Eat breakfast");
        //When
        Note save = noteRepository.save(note);
        Long id = save.getId();
        noteRepository.deleteById(id);
        //Then
        assertEquals(0, noteRepository.count());

    }

    @Test
    public void getAllNotes() {
        //Given
        Note note1 = new Note("Note1", "Eat breakfast");
        Note note2 = new Note("Note2", "Eat breakfast");
        //When
        Note saveNote1 = noteRepository.save(note1);
        Note saveNote2 = noteRepository.save(note2);
        Long noteId1 = saveNote1.getId();
        Long noteId2 = saveNote2.getId();
        int countOfNotes = (int) noteRepository.count();
        //Then
        Assert.assertEquals(2, countOfNotes);
        //CleanUp
        noteRepository.deleteById(noteId1);
        noteRepository.deleteById(noteId2);
    }

    @Test
    public void testGetNoteById() {
        //Given
        Note note = new Note("Note1", "Eat breakfast");
        //When
        Note saveNote = noteRepository.save(note);
        Long noteId = saveNote.getId();

        //Then
        Optional<Note> optionalNote = noteRepository.findById(noteId);
        Assert.assertTrue(optionalNote.isPresent());
        //CleanUp
        noteRepository.deleteById(noteId);

    }

}
