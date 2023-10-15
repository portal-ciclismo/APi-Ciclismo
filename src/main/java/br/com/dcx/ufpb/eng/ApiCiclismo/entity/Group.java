package br.com.dcx.ufpb.eng.ApiCiclismo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;

@Entity(name = "CyclistGroup")
public class Group {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Column(name = "DESCRIPTION")
    @NotBlank(message = "Description cannot be empty")
    private String description;

    @Column(name = "LOCATION")
    @NotBlank(message = "Location cannot be empty")
    private String location;

    @Column(name = "PRIVACY")
    @NotNull(message = "Privacy cannot be empty")
    private boolean privacy;
/*

    @ManyToMany // Falta fazer o contrário na classe profile
    @JoinTable(
            name = "GroupsParticipants",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id"))
    private Set<Profile> participants;
*/

    public Group(String name, String description, String location, Boolean privacy){
        this.name = name;
        this.description = description;
        this.location = location;
        this.privacy = privacy;
    }

    public Group(){

    }

    public Long getId(){ return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }
/*
    public Set<Profile> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Profile> participants) {
        this.participants = participants;
    }

 */

}

