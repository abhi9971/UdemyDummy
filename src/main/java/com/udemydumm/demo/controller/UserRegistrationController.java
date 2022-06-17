package com.udemydumm.demo.controller;


import com.udemydumm.demo.dto.ResponseDTO;
import com.udemydumm.demo.dto.UserDTO;
import com.udemydumm.demo.dto.UserLoginDTO;
import com.udemydumm.demo.model.UserRegistration;
import com.udemydumm.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {

    @Autowired
    UserService userRegistrationService;
    //Add User
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> addUserInBookStore(@Valid @RequestBody UserDTO userDTO){
        UserRegistration newUser= userRegistrationService.addUser(userDTO);
        ResponseDTO responseDTO=new ResponseDTO("User Registered Successfully",newUser);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }
    //Login
    @GetMapping("/login")
    public Integer userLogin(@RequestParam String email,@RequestParam String password) {
        UserLoginDTO userLoginDTO=new UserLoginDTO(email, password);
        Integer response = userRegistrationService.loginUser(userLoginDTO.getEmail(),userLoginDTO.getPassword());
        return response;
    }
}
