package br.com.dcx.ufpb.eng.ApiCiclismo.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;

public record EventDTO(String name, String description, String location, String date, String time, String duration, String distance, String difficulty, String route, String type, String group, String creator, List<Profile> participants) {

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getLocation(){
        return location;
    }

    public LocalDateTime getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }

    public String getDuration(){
        return duration;
    }

    public String getDistance(){
        return distance;
    }

    public String getDifficulty(){
        return difficulty;
    }

    public String getRoute(){
        return route;
    }

    public String getType(){
        return type;
    }

    public String getGroup(){
        return group;
    }

    public String getCreator(){
        return creator;
    }

    public List<Profile> getParticipants(){
        return participants;
    }
}
