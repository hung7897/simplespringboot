package com.todomvc.api.output;

import com.todomvc.dto.NoteDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Data tra ve cho client
 *     -totalpage
 *     -page
 *     -List<Note>
 */
public class NoteOutput {
    private int page;
    private int totalPage;
    private List<NoteDTO> noteDTOS= new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<NoteDTO> getNoteDTOS() {
        return noteDTOS;
    }

    public void setNoteDTOS(List<NoteDTO> noteDTOS) {
        this.noteDTOS = noteDTOS;
    }
}
