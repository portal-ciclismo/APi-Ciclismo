package br.com.dcx.ufpb.eng.ApiCiclismo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Table(name = "\"USER\"")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "Name cannot be empty/null")
    @Column(name = "NAME", length = 35)
    private String name;

    @Column(name = "PASSWORD", length = 12)
    @NotEmpty(message = "Name cannot be empty")
    private String password;

    @Email(message = "Email has to be valid !!")
    @Column(name = "EMAIL", unique = true)
    private String email;

    public User(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
