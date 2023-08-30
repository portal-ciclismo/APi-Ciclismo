package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import java.util.List;
import java.util.Optional;

import br.com.dcx.ufpb.eng.ApiCiclismo.exceptions.UserAlreadyExistsException;
import br.com.dcx.ufpb.eng.ApiCiclismo.exceptions.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.User;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(User user) {
        if(userRepository.findById(user.getId()).isEmpty()){
            throw new UserAlreadyExistsException("User already exists.");
        }
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long userId, User user) {
        Optional<User> existingUserOptional = userRepository.findById(userId);

        return existingUserOptional.map(existingUser -> {
            existingUser.setLogin(user.getLogin());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new UserNotFoundException("User not found in database."));
    }

    @Transactional
    public void deleteUser(Long userId) throws UserNotFoundException {
            userRepository.findById(userId).map(userFind -> {
                userRepository.delete(userFind);
                return userFind;
        }).orElseThrow(() -> new UserNotFoundException("User not found in database."));
    }

    public User getUserById(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found in database."));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
