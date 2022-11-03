package org.example.shop.service;

import org.example.shop.exception.UserNotFoundException;
import org.example.shop.repository.UserRepository;
import org.example.shop.security.UserDetailsImpl;
import org.example.shop.entity.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String uuid) throws UsernameNotFoundException {
        User user = userRepository
                .getUserById(UUID.fromString(uuid))
                .orElseThrow(UserNotFoundException::new);
        return new UserDetailsImpl(user);
    }
}
