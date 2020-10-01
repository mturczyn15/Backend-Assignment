package com.assignment.notes.mapper;

import com.assignment.notes.domain.Note;
import com.assignment.notes.domain.NoteDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoteMapper {

    public Note map(final NoteDto noteDto) {
        return new Note(
                noteDto.getId(),
                noteDto.getTitle(),
                noteDto.getContent(),
                noteDto.getCreated(),
                noteDto.getModified()
        );
    }

    public NoteDto mapToDto(final Note note) {
        return new NoteDto(
                note.getId(),
                note.getTitle(),
                note.getContent(),
                note.getCreated(),
                note.getModified()
        );
    }

    public List<NoteDto> mapToDtoList(final List<Note> noteList) {
        return noteList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
