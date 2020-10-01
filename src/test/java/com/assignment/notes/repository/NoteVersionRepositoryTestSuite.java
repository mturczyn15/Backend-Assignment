package com.assignment.notes.repository;

import com.assignment.notes.domain.Action;
import com.assignment.notes.domain.NoteVersion;
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
public class NoteVersionRepositoryTestSuite {

    @Autowired
    private NoteVersionRepository repository;

    @Test
    public void testSaveNoteVersion() {

        //Given
        NoteVersion note = new NoteVersion(1L, 1L, "Note1", "Eat breakfast", LocalDate.now(), null, Action.CREATE, 1);
        //When
        NoteVersion save = repository.save(note);
        Long id = save.getId();
        //Then
        assertNotEquals((Object) 0L, id);
        assertEquals("Note1", save.getTitle());
        assertEquals("Eat breakfast", save.getContent());
        assertEquals(1, save.getVersion());
        assertEquals(LocalDate.now(), save.getCreated());
        assertNull(save.getModified());
        //CleanUp
        repository.deleteById(id);

    }

    @Test
    public void testDeleteNote() {

        //Given
        NoteVersion note = new NoteVersion(1L, 1L, "Note1", "Eat breakfast", LocalDate.now(), null, Action.CREATE, 1);
        //When
        NoteVersion save = repository.save(note);
        Long id = save.getId();
        repository.deleteById(id);
        //Then
        assertEquals(0, repository.findAll().size());

    }

    @Test
    public void getAllNotes() {
        //Given
        NoteVersion note1 = new NoteVersion(1L, 1L, "Note1", "Eat breakfast", LocalDate.now(), null, Action.CREATE, 1);
        NoteVersion note2 = new NoteVersion(1L, 1L, "Note1", "Eat breakfast", LocalDate.now(), null, Action.CREATE, 1);
        //When
        NoteVersion saveNote1 = repository.save(note1);
        NoteVersion saveNote2 = repository.save(note2);
        Long noteId1 = saveNote1.getId();
        Long noteId2 = saveNote2.getId();
        int countOfNotes = repository.findAll().size();
        //Then
        Assert.assertEquals(2, countOfNotes);
        //CleanUp
        repository.deleteById(noteId1);
        repository.deleteById(noteId2);
    }

    @Test
    public void testGetNoteById() {
        //Given
        NoteVersion note1 = new NoteVersion(1L, 1L, "Note1", "Eat breakfast", LocalDate.now(), null, Action.CREATE, 1);
        //When
        NoteVersion saveNote = repository.save(note1);
        Long noteId = saveNote.getId();

        //Then
        Optional<NoteVersion> optionalNote = repository.findById(noteId);
        Assert.assertTrue(optionalNote.isPresent());
        //CleanUp
        repository.deleteById(noteId);

    }
}
