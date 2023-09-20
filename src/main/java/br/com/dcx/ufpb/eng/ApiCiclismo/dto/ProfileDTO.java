package br.com.dcx.ufpb.eng.ApiCiclismo.dto;

import br.com.dcx.ufpb.eng.ApiCiclismo.enums.UserType;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
public class ProfileDTO {

    private String fullName;
    private String nickname;
    private UserType userType;
    private CyclingCategory cyclingCategory;
    private String location;
    private byte[] profilePicture;

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
