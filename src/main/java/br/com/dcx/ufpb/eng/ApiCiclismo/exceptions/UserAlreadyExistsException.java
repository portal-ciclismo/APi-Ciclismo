package br.com.dcx.ufpb.eng.ApiCiclismo.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    private String errorMessage;
    public UserAlreadyExistsException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public UserAlreadyExistsException() {}
}
