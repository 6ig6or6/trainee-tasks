package org.example.shop.service;

import org.example.shop.dto.UserDTO;
import org.example.shop.exception.UserNotFoundException;
import org.example.shop.repository.UserRepository;
import org.example.shop.entity.user.Role;
import org.example.shop.entity.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User registerUser(UserDTO userDTO) {
        User user = new User();
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        setRole(user);
        logger.debug("User with UUID {} was registered", user.getId());
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(User user) {
        logger.debug("User with UUID {} was updated", user.getId());
        return userRepository.save(user);
    }

    @Transactional
    public User updateUserById(String id, UserDTO userDTO) {
        User user = userRepository
                .getUserById(UUID.fromString(id))
                .orElseThrow(UserNotFoundException::new);
        user.setPassword(userDTO.getPassword());
        logger.debug("Updating user with id {}", user.getId());
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUserById(String id) {
        User user = getUser(id);
        userRepository.delete(user);
        logger.debug("Deleting user with id {}", id);
    }

    public User getUser(String uuid) {
        return userRepository
                .getUserById(UUID.fromString(uuid))
                .orElseThrow(UserNotFoundException::new);
    }

    /**
     * First registered user is admin, then 3 managers and then all users
     */
    private void setRole(User user) {
        int quantityOfRegisteredUsers = userRepository.countAllBy();
        if (quantityOfRegisteredUsers == 0) {
            user.setRole(Role.ADMIN);
            logger.info("Setting role Admin for user {}", user.getId());
        } else if (quantityOfRegisteredUsers > 0 && quantityOfRegisteredUsers < 4) {
            user.setRole(Role.MANAGER);
            logger.info("Setting role Manager for user {}", user.getId());
        } else {
            user.setRole(Role.USER);
            logger.info("Setting standard role for user {}", user.getId());
        }
    }
}
