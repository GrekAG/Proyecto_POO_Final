package cine.main.proy_fin_aguero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cine.main.proy_fin_aguero.modelo.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
