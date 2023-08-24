package br.com.dcx.ufpb.eng.ApiCiclismo.dto;

import br.com.dcx.ufpb.eng.ApiCiclismo.enums.UserRole;

public class RegisterDTO {

    private String login;
    private String email;
    private String password;
    private String role;


    public RegisterDTO(String login, String email, String password, String role) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
    }


    public RegisterDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String userName) {
        this.login = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
