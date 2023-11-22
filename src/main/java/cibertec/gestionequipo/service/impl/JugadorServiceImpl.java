package cibertec.gestionequipo.service.impl;

import cibertec.gestionequipo.dao.entity.JugadorEntity;
import cibertec.gestionequipo.dao.repository.JugadorRepository;
import cibertec.gestionequipo.dto.JugadorDto;
import cibertec.gestionequipo.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JugadorServiceImpl  implements JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;
    @Override
    public JugadorEntity registrar(JugadorDto jugadorDto) {
        return jugadorRepository.save(this.mapearJugador(jugadorDto));
    }

    @Override
    public List<JugadorEntity> obtenerTodos() {
        return jugadorRepository.findAll();
    }

    @Override
    public JugadorEntity editar(JugadorDto jugadorDto) {
        return null;
    }

    @Override
    public void eliminar(Integer idJugador) {
        jugadorRepository.deleteById(idJugador);
    }

    @Override
    public JugadorEntity obtenerPorId(Integer id) {
        return  jugadorRepository.findById(id).get();
    }

    public JugadorEntity mapearJugador(JugadorDto jugadorDto){
        JugadorEntity jugadorEntity = new JugadorEntity();
        jugadorEntity.setNombreJugador(jugadorDto.getNombreJugador());
        jugadorEntity.setApellidoJugador(jugadorDto.getApellidoJugador());
        jugadorEntity.setTipoDocumento(jugadorDto.getTipoDocumento());
        jugadorEntity.setNumeroDocumento(jugadorDto.getNumeroDocumento());
        jugadorEntity.setFechaNacimiento(new Date());
        jugadorEntity.setPosicion(jugadorDto.getPosicion());
        return jugadorEntity;
    }
}
