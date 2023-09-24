package br.com.dcx.ufpb.eng.ApiCiclismo.enums;

public enum UserType {

    CYCLIST("cyclist"),
    COMPANY("company");

    private String type;

    UserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
