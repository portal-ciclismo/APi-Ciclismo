package br.com.dcx.ufpb.eng.ApiCiclismo.dto;

public class AuthenticationDTO {

    private String login;
    private String password;


    public String getLogin() {
        return login;
    }

    public void setEmail(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthenticationDTO() {
    }

    public AuthenticationDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
