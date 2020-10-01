package com.assignment.notes.mapper;

import com.assignment.notes.domain.NoteVersion;
import com.assignment.notes.domain.NoteVersionDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoteVersionMapper {

    public NoteVersion map(final NoteVersionDto version) {
        return new NoteVersion(
                version.getId(),
                version.getNoteId(),
                version.getTitle(),
                version.getContent(),
                version.getCreated(),
                version.getModified(),
                version.getAction(),
                version.getVersion()
        );
    }

    public NoteVersionDto mapToDto(final NoteVersion note) {
        return new NoteVersionDto(
                note.getId(),
                note.getNoteId(),
                note.getTitle(),
                note.getContent(),
                note.getCreated(),
                note.getModified(),
                note.getAction(),
                note.getVersion()
        );
    }

    public List<NoteVersionDto> mapToDtoList(final List<NoteVersion> noteList) {
        return noteList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
