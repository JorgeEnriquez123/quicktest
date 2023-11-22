package cibertec.gestionequipo.handler.excepcion;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpBaseExcepcion extends RuntimeException{
    private HttpStatus status;

    public HttpBaseExcepcion(HttpStatus status, String message){
        super(message);
        this.status = status;
    }
}
