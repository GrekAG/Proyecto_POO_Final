package cine.main.proy_fin_aguero.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cine implements Serializable {

    @Id
    private String cuit;

    @Basic
    private String nombre;

    @OneToMany(mappedBy = "cine", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Sala> salas;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "cine_pelicula",
            joinColumns = @JoinColumn(name = "cuit_cine"),
            inverseJoinColumns = @JoinColumn(name = "titulo_pelicula")
    )

    @JsonIgnoreProperties("cines")
    private List<Pelicula> peliculas;

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}