package org.example.shop.service;

import org.example.shop.user.Bucket;
import org.example.shop.exception.UserNotFoundException;
import org.example.shop.repository.UserRepository;
import org.example.shop.user.User;
import org.example.shop.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.UUID;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User registerUser(User user) {
        logger.debug("User with UUID {} was registered", user.getId());
        return userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
        logger.debug("User with UUID {} was updated", user.getId());
    }

    public User getUser(String uuid) {
        return userRepository
                .getUserById(UUID.fromString(uuid))
                .orElseThrow(UserNotFoundException::new);
    }

    @Transactional
    public User registerNewUser() {
        User user = new User();
        user.setBucket(new Bucket());
        logger.debug("Creating new user");
        return registerUser(user);
    }

    public User checkForRegistration() {
        logger.debug("Checking for user's registration was started");
        ConsoleHelper.printLine("Do you have an account already?\n" +
                "Enter yes or no");
        String answer = ConsoleHelper.readLine().toLowerCase(Locale.ROOT);
        if ("yes".equals(answer)) {
            ConsoleHelper.printLine("Enter you personal UUID");
            String uuid = ConsoleHelper.readLine();
            logger.debug("The client entered 'yes', calling getUser method");
            return getUser(uuid);
        } else if ("no".equals(answer)) {
            User user = registerNewUser();
            ConsoleHelper.printLine("Your personal UUID is " + user.getId());
            logger.debug("The client entered 'no', calling registerNewUser method");
            return user;
        } else {
            logger.warn("User entered unknown answer on registration stage");
            throw new UserNotFoundException();
        }
    }
}
