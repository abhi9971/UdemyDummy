package com.udemydumm.demo.service;

import com.udemydumm.demo.dto.UserDTO;
import com.udemydumm.demo.model.UserRegistration;
import com.udemydumm.demo.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    @Autowired
    UserRegistrationRepository  userRepository;
    public UserRegistration addUser(UserDTO userDTO) {
        UserRegistration newUser= new UserRegistration(userDTO);
        userRepository.save(newUser);

        return newUser;
    }


    public int loginUser(String email_id, String password) {
        Optional<UserRegistration> login = userRepository.findByEmailid(email_id);
        if(login.isPresent()){
            String pass = login.get().getPassword();
            System.out.println(pass);
            System.out.println(password);
            if(login.get().getPassword().equals(password)){
                return 1;// successful login
            }

            else {
                return 2;   //"Wrong Password";
            }
        }
        return  0;       //"User not found";
    }
}
