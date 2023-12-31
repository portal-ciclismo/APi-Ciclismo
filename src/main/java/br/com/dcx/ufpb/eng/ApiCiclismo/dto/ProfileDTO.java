package br.com.dcx.ufpb.eng.ApiCiclismo.dto;

import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;

public record ProfileDTO (Long id, UserDTO user, String fullName, String nickname, String sexo, CyclingCategory cyclingCategory, String location, boolean ciclistaProfissional, boolean ciclistaAmador){

    public UserDTO user() {
        return user;
    }

    public String getFullName() {
        return fullName;
    }
    public String getNickname() {
        return nickname;
    }

    public String getSexo() {
        return sexo;
    }

    public String getLocation() {
        return location;
    }

    public void setFullName(String novoNome) {
    }

    public CyclingCategory getCyclingCategory() {
        return this.cyclingCategory;
    }
}

