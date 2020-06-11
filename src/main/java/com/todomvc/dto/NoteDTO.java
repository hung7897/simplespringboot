package com.todomvc.dto;

import java.util.Date;

public class NoteDTO {
    private Long id;
    private String note;
    private Date createDate;
    private Long userId;
    private UserDTO userDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

//    public UserDTO getUserDTO() {
//        return userDTO;
//    }
//
//    public void setUserDTO(UserDTO userDTO) {
//        this.userDTO = userDTO;
//    }
}
