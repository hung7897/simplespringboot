package com.todomvc.api;

import com.todomvc.api.output.NoteOutput;
import com.todomvc.dto.NoteDTO;
import com.todomvc.repository.NoteRepository;
import com.todomvc.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteAPI {
    @Autowired
    private INoteService noteService;

    @PostMapping(value = "/note")
    public NoteDTO createNote(@RequestBody NoteDTO noteDTO) {
        return noteService.save(noteDTO);
    }

    @PutMapping(value = "/note/{id}")
    public NoteDTO updateNote(@RequestBody NoteDTO noteDTO, @PathVariable("id") Long id) {
        noteDTO.setId(id);
        return noteService.save(noteDTO);
    }

    @GetMapping(value = "/note")
    public NoteOutput showNote(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit) {
        NoteOutput noteOutput = new NoteOutput();
        if (page != null && limit != null) {
            noteOutput.setPage(page);
            Pageable pageable = PageRequest.of(page - 1, limit);
            noteOutput.setNoteDTOS(noteService.findAll(pageable));
            noteOutput.setTotalPage((int) Math.ceil((double) (noteService.totalItem()) / limit));
        } else {
            noteOutput.setNoteDTOS(noteService.findAll());
        }
        return noteOutput;
    }

    @DeleteMapping(value = "/note/{id}")
    public void deleteNote(@PathVariable("id") Long id) {
        noteService.delete(id);
    }
}
