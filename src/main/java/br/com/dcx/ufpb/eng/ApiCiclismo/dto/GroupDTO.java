package br.com.dcx.ufpb.eng.ApiCiclismo.dto;

public record GroupDTO(String name, String description, String location) {

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getLocation(){
        return location;
    }


}
