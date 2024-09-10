package com.robert.test.app.services;

import com.robert.test.app.models.Userul;
import com.robert.test.app.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Userul> getUser() {
        return this.userRepository.findAll();
    }

    public void addUser(Userul userul) {
        Optional<Userul> optionalUser = userRepository.findUserByEmail(userul.getEmail());
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("already exist");
        }
        userRepository.save(userul);
    }

    public void deleteUser(Long id) {
        boolean find = userRepository.existsById(id);
        if (!find) {
            throw new IllegalStateException("user not find");
        }
        userRepository.deleteById(id);
    }

    public void updateUser(Long id, String name, String email) {
        Userul userul = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("syudent not found")
        );

        if (name != null && name.length() > 0 && !userul.getName().equals(name)) {
            userul.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(userul.getEmail(), email)) {
            Optional<Userul> user1 = userRepository.findUserByEmail(email);
            if (user1.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            userul.setEmail(email);
        }

    }
}
