package com.tangorabox.userstore.controller;

import com.tangorabox.userstore.entity.User;
import com.tangorabox.userstore.model.UserDTO;
import com.tangorabox.userstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        User newUser = userRepository.save(User.fromDto(userDTO));
        return ResponseEntity.ok(newUser.toDTO());
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDTO> getUsersById(Long id) {
        return ResponseEntity.of(userRepository.findById(id).map(User::toDTO));
    }

    @Override
    public ResponseEntity<List<UserDTO>> listUsers() {
        return ResponseEntity.ok(
                StreamSupport.stream(userRepository.findAll().spliterator(), false)
                        .map(User::toDTO).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<Void> updateUser(Long id, UserDTO userDTO) {
        User user = User.fromDto(userDTO);
        user.setId(id);
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }
}
