package cine.main.proy_fin_aguero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import cine.main.proy_fin_aguero.modelo.Funcion;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Integer> {
    @Query("SELECT COUNT(f) > 0 FROM Funcion f JOIN f.entradas e " +
            "WHERE f.pelicula.titulo = :peliculaTitulo " +
            "AND f.horario = :horario " +
            "AND e.asiento = :asiento " +
            "AND e.precio = :precio")
    boolean existeAsientoOcupado(
            @Param("peliculaTitulo") String peliculaTitulo,
            @Param("horario") String horario,
            @Param("asiento") String asiento,
            @Param("precio") double precio
    );
}

