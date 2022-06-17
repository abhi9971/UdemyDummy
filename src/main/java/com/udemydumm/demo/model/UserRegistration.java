package com.udemydumm.demo.model;

import com.udemydumm.demo.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class UserRegistration {
    @Id
    @GeneratedValue
    private Integer userId;
    private String firstName;

    private String lastName;
    private String email;
    private String address;
    private String password;

    public UserRegistration(Integer userId, String firstName, String lastName, String email, String address, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public UserRegistration(UserDTO user) {
        this.firstName= user.getFirstName();
        this.lastName=user.getLastName();
        this.email= user.getEmail();
        this.address=user.getAddress();
        this.password=user.getPassword();
    }
}
