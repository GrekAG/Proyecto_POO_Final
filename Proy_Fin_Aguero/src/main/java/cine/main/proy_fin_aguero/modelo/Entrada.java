package cine.main.proy_fin_aguero.modelo;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "entrada")
public class Entrada implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEntrada")
    private Integer idEntrada;

    @Column(name = "asiento")
    private String asiento;

    @Column(name = "precio")
    private double precio;

    public Integer getIdEntrada() { return idEntrada; }
    public void setIdEntrada(Integer idEntrada) { this.idEntrada = idEntrada; }
    public String getAsiento() { return asiento; }
    public void setAsiento(String asiento) { this.asiento = asiento; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
