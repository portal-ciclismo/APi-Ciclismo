package br.com.dcx.ufpb.eng.ApiCiclismo.controller;

import br.com.dcx.ufpb.eng.ApiCiclismo.exception.ApiErros;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.UserNotFoudException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handMethodNotValidException(MethodArgumentNotValidException ex){
        List<String> msgErro= ex.getBindingResult().getAllErrors().stream().map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());
        return new ApiErros(msgErro);
    }

    @ExceptionHandler(UserNotFoudException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErros handUserNotFoudExceptions(UserNotFoudException ex){
        String msgErro = ex.getMessage();
        return new ApiErros(msgErro);
    }

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseBody
    public ApiErros handResponseStatusException(ResponseStatusException ex){
        String msgErro = ex.getMessage();
        return new ApiErros(msgErro);
    }





}
