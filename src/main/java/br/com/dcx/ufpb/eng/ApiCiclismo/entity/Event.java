package br.com.dcx.ufpb.eng.ApiCiclismo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Event implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_ID")
    private Long event_id;

    @NotBlank(message = "Event name cannot be blank.")
    private String name;

    private LocalDateTime date;

    @ManyToMany
    @JoinTable(
            name = "EVENT_PARTICIPANTS",
            joinColumns = @JoinColumn(name = "EVENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROFILE_ID")
    )
    private List<Profile> participants;

    @NotBlank(message = "Start location cannot be blank.")
    private String StartLocation;

    @NotBlank(message = "End location cannot be blank.")
    private String EndLocation;

    @NotBlank(message = "Event level cannot be blank.")
    private String level;

    @NotBlank(message = "Average speed cannot be blank.")
    private String speed;

    @NotBlank(message = "Event description cannot be blank.")
    private String description;

    public Event() {
    }

    public Event(Long event_id, String name, LocalDateTime date, List<Profile> participants, String startLocation, String endLocation, String level, String speed, String description) {
        this.event_id = event_id;
        this.name = name;
        this.date = date;
        this.participants = participants;
        StartLocation = startLocation;
        EndLocation = endLocation;
        this.level = level;
        this.speed = speed;
        this.description = description;
    }

    public Long getEventId() {
        return event_id;
    }

    public void setEventId(Long event_id) {
        this.event_id = event_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Profile> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Profile> participants) {
        this.participants = participants;
    }

    public String getStartLocation() {
        return StartLocation;
    }

    public void setStartLocation(String startLocation) {
        StartLocation = startLocation;
    }

    public String getEndLocation() {
        return EndLocation;
    }

    public void setEndLocation(String endLocation) {
        EndLocation = endLocation;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
