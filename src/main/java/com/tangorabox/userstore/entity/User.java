package com.tangorabox.userstore.entity;

import com.tangorabox.userstore.model.UserDTO;
import com.tangorabox.userstore.model.UserRequestDTO;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "USERS")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private LocalDate birthdate;

    public static User fromDto(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setBirthdate(userDTO.getBirthdate());
        return user;
    }

    public static User fromDto(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setBirthdate(userRequestDTO.getBirthdate());
        return user;
    }

    public UserDTO toDTO() {
        UserDTO result = new UserDTO();
        result.setId(getId());
        result.setName(getName());
        result.setBirthdate(getBirthdate());
        return result;
    }
}