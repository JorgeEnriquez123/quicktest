package cibertec.gestionequipo.handler.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubErrores {
    private String fields;
    private Object rejectValue;
    private String message;

    SubErrores(String message){
        this.message = message;
    }
}
