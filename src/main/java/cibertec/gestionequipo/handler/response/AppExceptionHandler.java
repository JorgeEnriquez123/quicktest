package cibertec.gestionequipo.handler.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorResponse apiError = ErrorResponse.builder()
                .status(httpStatus.value()).timestamp(LocalDateTime.now()).message("Validando en la capa de entrada").build();
        apiError.addValidationError(ex.getBindingResult().getFieldErrors());
        return buildResponseEntity(apiError,httpStatus);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse apiError, HttpStatus status){
        return new ResponseEntity<>(apiError,status);
    }

    /*ERROR 500 (de bd)*/

    @ExceptionHandler({Throwable.class})
    public ResponseEntity<Object> serverErrorException(Throwable ex){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse apiError = ErrorResponse.builder()
                .status(httpStatus.value()).timestamp(LocalDateTime.now()).message(ex.getMessage()).build();
        return  buildResponseEntity(apiError, httpStatus);
    }
}
