package org.example.shop.controller;

import org.example.shop.dto.UserDTO;
import org.example.shop.service.UserService;
import org.example.shop.entity.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<User> getUserById(@RequestParam String id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.registerUser(userDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestParam String id,
                                           @Valid @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.updateUserById(id, userDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam String id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
