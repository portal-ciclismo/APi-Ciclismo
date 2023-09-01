package br.com.dcx.ufpb.eng.ApiCiclismo.Exception;

public class UnauthenticatedUserException extends Exception{
    public UnauthenticatedUserException(String msg){
        super(msg);
    }
}
