package br.com.dcx.ufpb.eng.ApiCiclismo.controller;


import br.com.dcx.ufpb.eng.ApiCiclismo.dto.UserDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.EmailModel;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.User;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.EmailNotFoundException;

import br.com.dcx.ufpb.eng.ApiCiclismo.exception.UserNotFoudException;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.EmailService;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.serviceIMPL.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService usuarioService;

    @Autowired
    EmailService emailService;

    public UserController(UserService usuarioService, EmailService emailService) {
        this.usuarioService = usuarioService;
        this.emailService = emailService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return usuarioService.getUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        emailService.sendEmail(new EmailModel(), user);
        return usuarioService.saveUser(user);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserById(@PathVariable Long id) throws UserNotFoudException {
        return usuarioService.getUserById(id);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) throws UserNotFoudException {
        usuarioService.deleteUser(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void UpdateUser(@PathVariable Long id, @RequestBody UserDTO user) throws UserNotFoudException {
        usuarioService.UpdateUser(id, user);
    }

    @GetMapping(value = "/user/{email}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByEmail(@PathVariable String email) throws EmailNotFoundException {
        return usuarioService.getByEmail(email);
    }

}
