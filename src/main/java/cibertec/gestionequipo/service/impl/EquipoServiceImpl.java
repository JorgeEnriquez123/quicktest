package cibertec.gestionequipo.service.impl;

import cibertec.gestionequipo.dao.entity.EquipoEntity;
import cibertec.gestionequipo.dao.repository.EquipoRepository;
import cibertec.gestionequipo.dto.EquipoDto;
import cibertec.gestionequipo.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;
    @Override
    public EquipoEntity registrar(EquipoDto equipoDto) {
        EquipoEntity equipoEntity = new EquipoEntity();
        equipoEntity.setNombreEquipo(equipoDto.getNombreEquipo());
        equipoEntity.setEstadio(equipoDto.getEstadio());
        equipoEntity.setFechaFundacion(new Date());
        equipoRepository.save(equipoEntity);
        return equipoEntity;
    }

    @Override
    public List<EquipoEntity> obtenerTodos() {
        return equipoRepository.findAll();
    }

    @Override
    public EquipoEntity editar(EquipoDto equipoDto) {
        EquipoEntity equipoEntity = equipoRepository.findById(equipoDto.getIdEquipo()).get();
        equipoEntity.setNombreEquipo(equipoDto.getNombreEquipo());
        equipoEntity.setEstadio(equipoDto.getEstadio());
        equipoRepository.save(equipoEntity);
        return equipoEntity;
    }

    @Override
    public void eliminar(Integer idEquipo) {
        equipoRepository.deleteById(idEquipo);
    }

    @Override
    public EquipoEntity obtenerEquipo(Integer idEquipo) {
        Optional<EquipoEntity> equipoEntity =  equipoRepository.findById(idEquipo);
        //return equipoEntity.isEmpty() == false ? equipoEntity.get() : null;
        return  equipoEntity.get();
    }
}
