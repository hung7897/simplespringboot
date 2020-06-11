package com.todomvc.api;

import com.todomvc.api.output.UserOutput;
import com.todomvc.dto.UserDTO;
import com.todomvc.entity.UserEntity;
import com.todomvc.repository.UserRepository;
import com.todomvc.service.IUSerService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAPI {
    @Autowired
    private IUSerService userService;
    @GetMapping(value = "/user")
    public UserOutput showUser(@RequestParam(value = "page",required = false) Integer page,@RequestParam(value = "limit",required = false) Integer limit){
        UserOutput userOutput = new UserOutput();
        if(page != null && limit !=null){
            userOutput.setPage(page);
            Pageable pageable = PageRequest.of(page - 1, limit);
            userOutput.setUserDTOS(userService.finddAll(pageable));
            userOutput.setTotalPage((int) Math.ceil((double) (userService.totalItem()) / limit));
        }
        else{
            userOutput.setUserDTOS(userService.findAll());
        }
        return userOutput;
    }
    @PostMapping(value = "/user")
    public UserDTO save(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }
    @DeleteMapping(value = "/user/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }
    @PutMapping(value = "/user/{id}")
    public UserDTO editUser(@RequestBody UserDTO userDTO,@PathVariable("id") Long id){
        userDTO.setId(id);
        return userService.update(userDTO);
    }
}
