package com.assignment.notes.repository;

import com.assignment.notes.domain.NoteVersion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface NoteVersionRepository extends CrudRepository<NoteVersion, Long> {

    @Override
    NoteVersion save(NoteVersion note);


    List<NoteVersion> findByNoteId(Long noteId);

    @Override
    List<NoteVersion> findAll();


    Optional<NoteVersion> findById(Long id);

}
