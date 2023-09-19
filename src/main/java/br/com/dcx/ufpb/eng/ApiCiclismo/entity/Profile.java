package br.com.dcx.ufpb.eng.ApiCiclismo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serial;

@Entity
public class Profile {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "O nome completo não pode estar em branco")
    @Size(max = 100, message = "O nome completo deve ter no máximo 100 caracteres")
    private String fullName;

    @Size(max = 50, message = "O apelido deve ter no máximo 50 caracteres")
    private String nickname;

    @Enumerated(EnumType.STRING)
    private CyclingCategory cyclingCategory;

    @NotNull(message = "O tipo de usuário não pode ser nulo")
    private UserType userType;

    @Size(max = 100, message = "A localização deve ter no máximo 100 caracteres")
    private String location;

    @Lob
    private byte[] profilePicture;

    public enum CyclingCategory {}

    public enum UserType {
        AMATEUR, PROFESSIONAL
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public CyclingCategory getCyclingCategory() {
        return cyclingCategory;
    }

    public void setCyclingCategory(CyclingCategory cyclingCategory) {
        this.cyclingCategory = cyclingCategory;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
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
