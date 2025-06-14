package cine.main.proy_fin_aguero.modelo;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    @Id
    @Column(name = "NOMBRE")
    private String nombre;

    @Basic
    @Column(name = "EMAIL")
    private String email;

    public Cliente() {}
    public Cliente(String nombre, String email) { this.nombre = nombre; this.email = email; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
