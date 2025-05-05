package com.example.hoteltransito.service;
import com.example.hoteltransito.model.User;
import com.example.hoteltransito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public Optional<User> update(Long id, User user) {
        return userRepository.findById(id)
                .map(existing -> {
                    existing.setUsername(user.getUsername());
                    existing.setEmail(user.getEmail());
                    existing.setPasswordHash(user.getPasswordHash());
                    existing.setFullName(user.getFullName());
                    existing.setUpdatedAt(user.getUpdatedAt());
                    return userRepository.save(existing);
                });
    }

    @Transactional
    public boolean delete(Long id) {
        return userRepository.findById(id)
                .map(existing -> {
                    userRepository.delete(existing);
                    return true;
                }).orElse(false);
    }
}

