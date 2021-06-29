package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;

import org.springframework.stereotype.Service;

@Service
public class NoteService {
    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    public void save(String noteId, String noteTitle, String noteDescription, Integer userId) {
        if (noteId == null || noteId.length() < 1) {
            noteMapper.create(noteTitle, noteDescription, userId);
        } else {
            Note note = new Note(Integer.valueOf(noteId), noteTitle, noteDescription, userId);
            noteMapper.save(note);
        }
    }

    public Note[] list(Integer userId) {
        return noteMapper.list(userId);
    }

    public Note get(Integer noteId) {
        return noteMapper.get(noteId);
    }

    public void delete(Integer noteId) {
        noteMapper.delete(noteId);
    }
}
