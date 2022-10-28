package org.example.shop.service;

import org.example.shop.user.Bucket;
import org.example.shop.exception.UserNotFoundException;
import org.example.shop.repository.UserRepository;
import org.example.shop.user.User;
import org.example.shop.util.ConsoleHelper;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public User getUser(String uuid) {
        return userRepository
                .getUserById(UUID.fromString(uuid))
                .orElseThrow(UserNotFoundException::new);
    }

    public User registerNewUser() {
        User user = new User();
        user.setBucket(new Bucket());
        return registerUser(user);
    }

    public User checkForRegistration() {
        ConsoleHelper.printLine("Do you have an account already?\n" +
                "Enter yes or no");
        String answer = ConsoleHelper.readLine().toLowerCase(Locale.ROOT);
        if ("yes".equals(answer)) {
            ConsoleHelper.printLine("Enter you personal UUID");
            String uuid = ConsoleHelper.readLine();
            return getUser(uuid);
        } else if ("no".equals(answer)) {
            User user = registerNewUser();
            ConsoleHelper.printLine("Your personal UUID is " + user.getId());
            return user;
        } else {
            throw new UserNotFoundException();
        }
    }
}
