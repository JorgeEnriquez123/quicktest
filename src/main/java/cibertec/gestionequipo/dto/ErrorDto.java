package cibertec.gestionequipo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDto {
    private String status;
    private String error;
    private String message;
}
