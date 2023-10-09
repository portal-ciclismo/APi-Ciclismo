package br.com.dcx.ufpb.eng.ApiCiclismo.service.serviceIMPL;

import java.util.List;
import java.util.Optional;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.UserDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.EmailNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.UserNotFoudException;
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


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) throws UserNotFoudException {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()) {
            throw new UserNotFoudException( "User not found.");
        }
        return optionalUser;
    }


    public void deleteUser(Long id) throws UserNotFoudException {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()) {
            throw new UserNotFoudException( "User not found.");
        }
        userRepository.deleteById(id);
    }


    public void UpdateUser(Long id, UserDTO userDTO) throws UserNotFoudException {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()) {
            throw new UserNotFoudException( "User not found.");
        }
        User user = optionalUser.get();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
    }

    public User getByEmail(String email) throws EmailNotFoundException {
        try {
            return userRepository.findByEmail(email);
        } catch (Exception e) {
            throw new EmailNotFoundException("Email not found.");
        }

    }


}
