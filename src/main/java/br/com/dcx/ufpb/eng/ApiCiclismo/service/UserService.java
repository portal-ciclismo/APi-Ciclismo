package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.User;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public User updateUser(Long userId, User user) {
        Optional<User> existingUserOptional = userRepository.findById(userId);

        return existingUserOptional.map(existingUser -> {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found in DB"));
    }

    public void deleteUser(Long userId) {
            userRepository.findById(userId).map(userFind -> {
                userRepository.delete(userFind);
                return userFind;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not Find in DB"));
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not Find in DB"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
