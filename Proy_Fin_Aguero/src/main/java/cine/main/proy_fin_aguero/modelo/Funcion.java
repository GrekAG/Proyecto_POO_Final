package cine.main.proy_fin_aguero.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "funcion")
public class Funcion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFun")
    private Integer idFun;

    @Column(name = "horario")
    private String horario;

    @ManyToOne
    @JoinColumn(name = "PELICULA_TITULO")
    private Pelicula pelicula;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcion_id")
    private List<Entrada> entradas = new ArrayList<>();

    @ManyToMany(mappedBy = "funcion")
    @JsonIgnoreProperties("funcion")
    private List<Venta> ventas = new ArrayList<>();

    public Integer getIdFun() { return idFun; }
    public void setIdFun(Integer idFun) { this.idFun = idFun; }
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }
    public List<Entrada> getEntradas() { return entradas; }
    public void setEntradas(List<Entrada> entradas) { this.entradas = entradas; }
    public List<Venta> getVentas() { return ventas; }
    public void setVentas(List<Venta> ventas) { this.ventas = ventas; }
}
