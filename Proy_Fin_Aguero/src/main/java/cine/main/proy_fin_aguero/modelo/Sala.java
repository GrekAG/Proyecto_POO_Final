package cine.main.proy_fin_aguero.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sala")
@Inheritance(strategy = InheritanceType.JOINED)
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSala")
    private Integer idSala;

    @Basic
    @Column(name = "capacidad")
    private int capacidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cine_cuit")
    @JsonBackReference
    private Cine cine;

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }
}
