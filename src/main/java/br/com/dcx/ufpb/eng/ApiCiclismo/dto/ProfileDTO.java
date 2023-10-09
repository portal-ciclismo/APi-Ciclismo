package br.com.dcx.ufpb.eng.ApiCiclismo.dto;

import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
public class ProfileDTO {

    private String fullName;
    private String nickname;

    private String sexo;

    private UserType userType;
    private CyclingCategory cyclingCategory;
    private String location;
    private byte[] profilePicture;

    public ProfileDTO(String fullName, String nickname, String sexo, UserType userType, CyclingCategory cyclingCategory, String location, byte[] profilePicture) {
        this.fullName = fullName;
        this.nickname = nickname;
        this.sexo = sexo;
        this.userType = userType;
        this.cyclingCategory = cyclingCategory;
        this.location = location;
        this.profilePicture = profilePicture;
    }

    public ProfileDTO() {}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public CyclingCategory getCyclingCategory() {
        return cyclingCategory;
    }

    public void setCyclingCategory(CyclingCategory cyclingCategory) {
        this.cyclingCategory = cyclingCategory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
}
