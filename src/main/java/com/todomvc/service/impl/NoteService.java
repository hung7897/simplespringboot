package com.todomvc.service.impl;

import com.todomvc.converter.NoteConverter;
import com.todomvc.dto.NoteDTO;
import com.todomvc.entity.NoteEntity;
import com.todomvc.entity.UserEntity;
import com.todomvc.repository.NoteRepository;
import com.todomvc.repository.UserRepository;
import com.todomvc.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService implements INoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteConverter noteConverter;

    @Override
    public NoteDTO save(NoteDTO noteDTO) {
        NoteEntity noteEntity = new NoteEntity();
        if (noteDTO.getId() != null) {
            NoteEntity oldNoteEntity = noteRepository.findOneById(noteDTO.getId());
            noteEntity = noteConverter.toEntity(noteDTO, oldNoteEntity);
        } else {
            noteEntity = noteConverter.toEntity(noteDTO);
        }
        UserEntity userEntity = userRepository.findOneById(noteDTO.getUserId());
        noteEntity.setUser(userEntity);
        noteRepository.save(noteEntity);
        return noteConverter.toDTO(noteEntity);
    }
    @Override
    public List<NoteDTO> findAll() {
        List<NoteEntity> noteEntities = noteRepository.findAll();
        List<NoteDTO> noteDTOS = new ArrayList<>();
        for (NoteEntity noteEntity : noteEntities) {
            noteDTOS.add(noteConverter.toDTO(noteEntity));
        }
        return noteDTOS;
    }
    @Override
    public List<NoteDTO> findAll(Pageable pageable) {
        List<NoteDTO> noteDTOS = new ArrayList<>();
        List<NoteEntity> noteEntities = noteRepository.findAll(pageable).getContent();
        for (NoteEntity noteEntity : noteEntities) {
            noteDTOS.add(noteConverter.toDTO(noteEntity));
        }
        return noteDTOS;
    }

    @Override
    public int totalItem() {
        return (int) noteRepository.count();
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    /*@Override
    public NoteDTO update(NoteDTO noteDTO) {
        NoteEntity oldNoteEntity = noteRepository.findOneById(noteDTO.getId());
        NoteEntity noteEntity = noteConverter.toEntity(noteDTO,oldNoteEntity);
        UserEntity userEntity = userRepository.findOneById(noteDTO.getUserId());
        noteEntity.setUser(userEntity);
        noteRepository.save(noteEntity);
        return noteConverter.toDTO(noteEntity);
    }*/
}
