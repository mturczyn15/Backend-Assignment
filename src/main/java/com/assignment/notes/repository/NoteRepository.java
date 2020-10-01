package com.assignment.notes.repository;

import com.assignment.notes.domain.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface NoteRepository extends CrudRepository<Note, Long>  {

    @Override
    Note save(Note note);

    @Override
    List<Note> findAll();

    @Override
    Optional<Note> findById(Long id);

    @Override
    void deleteById(Long id);
}

