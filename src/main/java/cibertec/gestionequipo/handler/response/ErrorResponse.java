package cibertec.gestionequipo.handler.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class ErrorResponse {
    private Integer status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private List<SubErrores> subErrors;

    public ErrorResponse(){
        this.timestamp=LocalDateTime.now();
    }

    private void addSubErrors(SubErrores subErrores){
        if(subErrors == null){
            subErrors= new ArrayList<>();
        }
        subErrors.add(subErrores);
    }

    private void addValidationError(String object, String field, Object rejectValue,String message){
        addSubErrors(new SubErrores(field, rejectValue, message ));
    }

    private void addValidationError(String object, String message){
        addSubErrors(new SubErrores(message));
    }

    private void addValidationError(FieldError fieldError){
        this.addValidationError(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getRejectedValue(),
                fieldError.getDefaultMessage());
    }

    public void addValidationError(List<FieldError> fieldErrors){
        fieldErrors.forEach(this::addValidationError);
    }
}
