package br.com.dcx.ufpb.eng.ApiCiclismo.exceptions;

public class UserNotFoundException extends RuntimeException {
    private String errorMessage;
    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public UserNotFoundException() {}
}
