package br.com.dcx.ufpb.eng.ApiCiclismo.dto;

import java.util.List;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;

public record EventDTO(String name, String description, String startLocation, String endLocation, String date, String time, String level, List<Profile> participants, String speed) {

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getStartLocation(){
        return startLocation;
    }

    public String getEndLocation(){
        return endLocation;
    }

    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }


    public String getLevel(){
        return level;
    }

    public String getSpeed(){
        return speed;
    }

    public List<Profile> getParticipants(){
        return participants;
    }
}
