package com.todomvc.api.output;

import com.todomvc.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserOutput {
    private int page;
    private int totalPage;
    private List<UserDTO> userDTOS = new ArrayList<>();

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

    public List<UserDTO> getUserDTOS() {
        return userDTOS;
    }

    public void setUserDTOS(List<UserDTO> userDTOS) {
        this.userDTOS = userDTOS;
    }
}
