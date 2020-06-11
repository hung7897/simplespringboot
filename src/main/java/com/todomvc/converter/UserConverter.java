package com.todomvc.converter;

import com.todomvc.dto.NoteDTO;
import com.todomvc.dto.UserDTO;
import com.todomvc.entity.NoteEntity;
import com.todomvc.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {
    private NoteConverter noteConverter;
    public UserDTO toDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setPassWord(userEntity.getPassWord());
//        List<NoteDTO> noteDTOS = new ArrayList<>();
//        for(NoteEntity noteEntity : userEntity.getNoteEntities()){
//            noteDTOS.add(noteConverter.toDTO(noteEntity));
//        }
//        userDTO.setNoteDTOS(noteDTOS);
        return userDTO;
    }
    public UserEntity toEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setPassWord(userDTO.getPassWord());
        return userEntity;
    }
    public UserEntity toEntity(UserDTO userDTO, UserEntity userEntity){
        if(userDTO.getUserName() != null){
            userEntity.setUserName(userDTO.getUserName());
        }
        if(userDTO.getPassWord() !=null){
            userEntity.setPassWord(userDTO.getPassWord());
        }
        return userEntity;
    }
}
