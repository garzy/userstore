package com.tangorabox.userstore.controller;

import com.tangorabox.userstore.entity.User;
import com.tangorabox.userstore.exception.OperationException;
import com.tangorabox.userstore.model.UserDTO;
import com.tangorabox.userstore.model.UserRequestDTO;
import com.tangorabox.userstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/")
public class UsersApiController implements UsersApi {

    private final UserRepository userRepository;

    @Autowired
    public UsersApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> createUser(UserRequestDTO userRequestDTO) {
        User newUser = userRepository.save(User.fromDto(userRequestDTO));
        return ResponseEntity.ok(newUser.toDTO());
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception ex) {
            throw new OperationException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDTO> getUsersById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new OperationException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(user.toDTO());
    }

    @Override
    public ResponseEntity<List<UserDTO>> listUsers() {
        return ResponseEntity.ok(
                StreamSupport.stream(userRepository.findAll().spliterator(), false)
                        .map(User::toDTO).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<Void> updateUser(Long id, UserRequestDTO userRequestDTO) {
        if (userRepository.findById(id).isEmpty()) {
            throw new OperationException(HttpStatus.NOT_FOUND);
        }
        User user = User.fromDto(userRequestDTO);
        user.setId(id);
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }
}
