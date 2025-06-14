package cine.main.proy_fin_aguero.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @Column(name = "TITULO")
    private String titulo;

    @Basic
    @Column(name = "GENERO")
    private String genero;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
}
