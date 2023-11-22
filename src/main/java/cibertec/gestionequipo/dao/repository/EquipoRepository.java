package cibertec.gestionequipo.dao.repository;


import cibertec.gestionequipo.dao.entity.EquipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository  extends JpaRepository<EquipoEntity, Integer> {
}
