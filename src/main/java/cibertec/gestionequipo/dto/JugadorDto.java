package cibertec.gestionequipo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
public class JugadorDto {
    private int idJugador;
    @NotBlank(message = "El campo nombreJugador es requerido")
    private String nombreJugador;
    @NotBlank(message = "El campo apellidoJugador es requerido")
    private String apellidoJugador;
    private int tipoDocumento;
    private String  numeroDocumento;
    private Date fechaNacimiento;
    private String posicion;
}
