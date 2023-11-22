package cibertec.gestionequipo.service;

import cibertec.gestionequipo.dao.entity.EquipoEntity;
import cibertec.gestionequipo.dto.EquipoDto;

import java.util.List;

public interface EquipoService {

    EquipoEntity registrar(EquipoDto equipoDto);
    List<EquipoEntity> obtenerTodos();

    EquipoEntity editar(EquipoDto equipoDto);

    void eliminar(Integer idEquipo);

    EquipoEntity obtenerEquipo(Integer idEquipo);


}
