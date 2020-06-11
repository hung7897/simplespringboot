package com.todomvc.repository;

import com.todomvc.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<NoteEntity,Long> {
    NoteEntity findOneById(Long id);
    List<NoteEntity> findAllById(Long id);
    void deleteById(Long id);
    List<NoteEntity> findAllByUserId(Long id);
}
