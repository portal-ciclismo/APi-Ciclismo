package br.com.dcx.ufpb.eng.ApiCiclismo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serial;



@Entity(name = "User")
public class User  {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Column(name = "EMAIL", unique = true)
    @NotBlank(message = "Email cannot be empty/null")
    private String email;


    @Column(name = "PASSWORD")
    @NotEmpty(message = "Password cannot be empty")
    private String password;



    public User( String password, String email) {
        this.password = password;
        this.email = email;
    }

    public User() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
            this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
