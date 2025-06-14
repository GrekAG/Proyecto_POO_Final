package cine.main.proy_fin_aguero.modelo;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "salavip")
@PrimaryKeyJoinColumn(name = "sala_id")
public class SalaVIP extends Sala implements Serializable {

    @Basic
    @Column(name = "servicio")
    private String servicio;

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
}
