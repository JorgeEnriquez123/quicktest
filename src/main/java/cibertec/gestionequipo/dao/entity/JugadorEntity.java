package cibertec.gestionequipo.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="jugador")
public class JugadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJugador;
    private String nombreJugador;
    private String apellidoJugador;
    private int tipoDocumento;
    private String  numeroDocumento;
    private Date fechaNacimiento;
    private String posicion;
}
