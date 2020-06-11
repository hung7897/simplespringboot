package com.todomvc.service.impl;

import com.todomvc.converter.NoteConverter;
import com.todomvc.converter.UserConverter;
import com.todomvc.dto.NoteDTO;
import com.todomvc.dto.UserDTO;
import com.todomvc.entity.NoteEntity;
import com.todomvc.entity.UserEntity;
import com.todomvc.repository.NoteRepository;
import com.todomvc.repository.UserRepository;
import com.todomvc.service.IUSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUSerService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    UserConverter userConverter;
    @Autowired
    NoteConverter noteConverter;
    @Override
    public List<UserDTO> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(UserEntity userEntity : userEntities){
            userDTOS.add(userConverter.toDTO(userEntity));
        }
        for(UserDTO userDTO : userDTOS){
            List<NoteEntity> noteEntity = noteRepository.findAllByUserId(userDTO.getId());
            List<NoteDTO> noteDTOS = new ArrayList<>();
            for (NoteEntity noteEntity1 : noteEntity){
                noteDTOS.add(noteConverter.toDTO(noteEntity1));
            }
            userDTO.setNoteDTOS(noteDTOS);
        }
        return userDTOS;
    }

    @Override
    public List<UserDTO> finddAll(Pageable pageable) {
        List<UserEntity> userEntities = userRepository.findAll(pageable).getContent();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(UserEntity userEntity : userEntities){
            userDTOS.add(userConverter.toDTO(userEntity));
        }
        for(UserDTO userDTO : userDTOS){
            List<NoteEntity> noteEntity = noteRepository.findAllByUserId(userDTO.getId());
            List<NoteDTO> noteDTOS = new ArrayList<>();
            for (NoteEntity noteEntity1 : noteEntity){
                noteDTOS.add(noteConverter.toDTO(noteEntity1));
            }
            userDTO.setNoteDTOS(noteDTOS);
        }
        return userDTOS;
    }

    @Override
    public int totalItem() {
        return (int) userRepository.count();
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        UserEntity userEntity = userConverter.toEntity(userDTO);
        userRepository.save(userEntity);
        return userConverter.toDTO(userEntity);
    }


    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        if(userDTO.getId() != null){
            UserEntity oldUserEntity = userRepository.findOneById(userDTO.getId());
            userEntity = userConverter.toEntity(userDTO,oldUserEntity);
        }
        else {
            userEntity = userConverter.toEntity(userDTO);
        }
        userRepository.save(userEntity);
        return userConverter.toDTO(userEntity);
//        UserEntity oldUserEntity = userRepository.findOneById(userDTO.getId());
//        UserDTO userDTO1 = userConverter.toDTO(oldUserEntity);
//        if(userDTO.getUserName() != null ){
//            userDTO1.setUserName(userDTO.getUserName());
//        }
//        if(userDTO.getPassWord() != null){
//            userDTO1.setPassWord(userDTO.getPassWord());
//        }
//        List<NoteDTO> noteDTOS = new ArrayList<>();
//        for (NoteEntity noteEntity : oldUserEntity.getNoteEntities()){
//            noteDTOS.add(noteConverter.toDTO(noteEntity));
//        }
//        userDTO1.setNoteDTOS(noteDTOS);
//        return userDTO1;
    }
}
