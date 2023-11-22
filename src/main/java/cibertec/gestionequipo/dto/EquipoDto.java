package cibertec.gestionequipo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
public class EquipoDto {
    private int idEquipo;
    @NotBlank(message = "El campo nombreEquipo es requerido")
    private String nombreEquipo;
    @NotBlank(message = "El campo estadio es requerido")
    private String estadio;
    private Date fechaFundacion;
}
