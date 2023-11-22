package cibertec.gestionequipo.service;

import cibertec.gestionequipo.dao.entity.JugadorEntity;
import cibertec.gestionequipo.dto.JugadorDto;

import java.util.List;

public interface JugadorService {

    JugadorEntity registrar(JugadorDto jugadorDto);
    List<JugadorEntity> obtenerTodos();

    JugadorEntity editar(JugadorDto jugadorDto);

    void eliminar(Integer idJugador);

    JugadorEntity obtenerPorId(Integer id);
}
