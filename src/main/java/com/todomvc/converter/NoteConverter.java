package com.todomvc.converter;

import com.todomvc.dto.NoteDTO;
import com.todomvc.dto.UserDTO;
import com.todomvc.entity.NoteEntity;
import com.todomvc.entity.UserEntity;
import com.todomvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoteConverter {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    public NoteEntity toEntity(NoteDTO noteDTO) {
        NoteEntity entity = new NoteEntity();
        entity.setId(noteDTO.getId());
        entity.setNote(noteDTO.getNote());
        entity.setCreateDate(noteDTO.getCreateDate());
        return entity;
    }

    public NoteDTO toDTO(NoteEntity noteEntity) {
        NoteDTO dto = new NoteDTO();
        dto.setId(noteEntity.getId());
        dto.setNote(noteEntity.getNote());
        dto.setCreateDate(noteEntity.getCreateDate());
        dto.setUserId(noteEntity.getUser().getId());
        return dto;
    }

    public NoteEntity toEntity(NoteDTO noteDTO, NoteEntity noteEntity) {
        if (noteDTO.getNote() != null) {
            noteEntity.setNote(noteDTO.getNote());
        }
        noteEntity.setId(noteDTO.getId());
        noteEntity.setCreateDate(noteDTO.getCreateDate());
        noteEntity.setUser(userRepository.findOneById(noteDTO.getUserId()));
        return noteEntity;
    }
}
