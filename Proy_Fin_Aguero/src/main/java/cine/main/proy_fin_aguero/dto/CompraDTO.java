package cine.main.proy_fin_aguero.dto;

public class CompraDTO {
    private String nombreCli;
    private String correoCli;
    private String asiento;
    private String horario;
    private String precio; // "Sala Comun - $5000" o "Sala VIP - $7000"
    private String peliculaTitulo;

    // Getters y Setters
    public String getNombreCli() { return nombreCli; }
    public void setNombreCli(String nombreCli) { this.nombreCli = nombreCli; }
    public String getCorreoCli() { return correoCli; }
    public void setCorreoCli(String correoCli) { this.correoCli = correoCli; }
    public String getAsiento() { return asiento; }
    public void setAsiento(String asiento) { this.asiento = asiento; }
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    public String getPrecio() { return precio; }
    public void setPrecio(String precio) { this.precio = precio; }
    public String getPeliculaTitulo() { return peliculaTitulo; }
    public void setPeliculaTitulo(String peliculaTitulo) { this.peliculaTitulo = peliculaTitulo; }
}
