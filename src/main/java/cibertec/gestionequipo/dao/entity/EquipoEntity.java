package cibertec.gestionequipo.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="equipo")
public class EquipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipo;
    private String nombreEquipo;
    private String estadio;
    private Date fechaFundacion;
}
