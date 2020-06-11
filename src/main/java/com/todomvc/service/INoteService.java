package com.todomvc.service;

import com.todomvc.dto.NoteDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INoteService {
    NoteDTO save(NoteDTO noteDTO);
    //NoteDTO update(NoteDTO noteDTO);
    List<NoteDTO> findAll();
    List<NoteDTO> findAll(Pageable pageable);
    int totalItem();
    void delete(Long id);
}
