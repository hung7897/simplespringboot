package com.todomvc.dto;

import java.util.List;

public class UserDTO {
    private Long id;
    private String userName;
    private String passWord;
    List<NoteDTO> noteDTOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<NoteDTO> getNoteDTOS() {
        return noteDTOS;
    }

    public void setNoteDTOS(List<NoteDTO> noteDTOS) {
        this.noteDTOS = noteDTOS;
    }
}
