package br.com.dcx.ufpb.eng.ApiCiclismo.entity;

import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    private User user;

    @NotBlank(message = "O nome completo não pode estar em branco")
    @Size(max = 255, message = "O nome completo deve ter no máximo 100 caracteres")
    @Column(name = "FULLNAME")
    private String fullName;

    @Size(max = 255, message = "O apelido deve ter no máximo 50 caracteres")
    @Column(name = "NICKNAME")
    private String nickname;

    @NotBlank(message = "O nickname não pode estar em branco")
    @Size(max=20, message = "O sexo deve ter no máximo 100 caracteres" )
    @Column(name = "SEX")
    private String sexo;

    @NotBlank(message = "O cyclingCategory não pode estar em branco")
    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY")
    private CyclingCategory cyclingCategory;

    @NotBlank(message = "O location não pode estar em branco")
    @Size(max = 35, message = "A localização deve ter no máximo 100 caracteres")
    @Column(name = "LOCALITY")
    private String location;

    @Lob
    @Column(name = "PROFILEPICTURE")
    private byte[] profilePicture;

    public Profile (){
    }
    public Profile(Long id, String fullName, String nickname, String sexo, CyclingCategory cyclingCategory,
                   String location, byte[] profilePicture, User user) {
        this.id = id;
        this.fullName = fullName;
        this.nickname = nickname;
        this.sexo = sexo;
        this.cyclingCategory = cyclingCategory;
        this.location = location;
        this.profilePicture = profilePicture;
        this.user = user;
    }

    public  boolean getCiclistaAmador(){
        return getCyclingCategory() == CyclingCategory.AMADOR;
    }

    public void setCiclistaAmador() {
        setCyclingCategory(CyclingCategory.AMADOR);
    }

    public  boolean getCiclistaProfissional(){
        return getCyclingCategory() == CyclingCategory.PROFISSIONAL;
    }
    public void setCiclistaProfissional() {
        setCyclingCategory(CyclingCategory.PROFISSIONAL);
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}