package cine.main.proy_fin_aguero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cine.main.proy_fin_aguero.modelo.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {
}
