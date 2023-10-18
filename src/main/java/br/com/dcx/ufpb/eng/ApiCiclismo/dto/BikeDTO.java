package br.com.dcx.ufpb.eng.ApiCiclismo.dto;

public record BikeDTO(String frameMaterial, String frameBrand, Integer wheelSize){

    public String getFrameMaterial(){
        return frameMaterial;
    }

    public String getFrameBrand(){
        return frameBrand;
    }

    public Integer getWheelSize(){
        return wheelSize;
    }

}
