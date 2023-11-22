package cibertec.gestionequipo.handler.excepcion;

import org.springframework.http.HttpStatus;
public class BadRequestException extends HttpBaseExcepcion{
    public BadRequestException(String message){
        super(HttpStatus.BAD_REQUEST,message);
    }
}
