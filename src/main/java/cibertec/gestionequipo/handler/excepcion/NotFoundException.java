package cibertec.gestionequipo.handler.excepcion;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpBaseExcepcion{

    public NotFoundException(String message){
        super(HttpStatus.NOT_FOUND, message);
    }
}
