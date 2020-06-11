package com.todomvc.service;

import com.todomvc.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUSerService {
    List<UserDTO> findAll();
    List<UserDTO> finddAll(Pageable pageable);
    int totalItem();
    UserDTO save(UserDTO userDTO);
    void delete(Long id);
    UserDTO update(UserDTO userDTO);
}
