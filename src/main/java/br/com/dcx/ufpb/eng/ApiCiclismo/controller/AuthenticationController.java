package br.com.dcx.ufpb.eng.ApiCiclismo.controller;


import br.com.dcx.ufpb.eng.ApiCiclismo.dto.AuthenticationDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.dto.LoginResponseDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.dto.RegisterDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.User;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.UserRole;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.TokenService;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("auth")
@Tag(name =  "Auth EndPoint")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.getLogin(), authenticationDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/new-register")
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@RequestBody @Valid RegisterDTO registerDTO){
            if (registerDTO == null) return (User) ResponseEntity.badRequest();
            String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.getPassword());
            User newUser = new User(registerDTO.getLogin(), encryptedPassword, registerDTO.getEmail(), UserRole.valueOf(registerDTO.getRole()));
            userService.createUser(newUser);
            return newUser;
    }
}
