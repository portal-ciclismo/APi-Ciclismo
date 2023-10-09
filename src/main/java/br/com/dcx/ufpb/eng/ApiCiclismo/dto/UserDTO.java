package br.com.dcx.ufpb.eng.ApiCiclismo.dto;

public record UserDTO (String email, String password) {
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

