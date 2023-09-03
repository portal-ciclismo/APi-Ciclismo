package br.com.dcx.ufpb.eng.ApiCiclismo.exception;

public class UnauthenticatedUserException extends Exception{
    public UnauthenticatedUserException(String msg){
        super(msg);
    }
}
