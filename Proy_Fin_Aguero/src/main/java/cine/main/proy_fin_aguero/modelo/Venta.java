package cine.main.proy_fin_aguero.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDVENT")
    private Integer idVent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    private Date fecha;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "venta_funcion",
            joinColumns = @JoinColumn(name = "Venta_IDVENT"),
            inverseJoinColumns = @JoinColumn(name = "funcion_IDFUN")
    )
    @JsonIgnoreProperties("ventas")
    private List<Funcion> funcion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "venta_cliente",
            joinColumns = @JoinColumn(name = "Venta_IDVENT"),
            inverseJoinColumns = @JoinColumn(name = "cliente_NOMBRE")
    )
    private List<Cliente> cliente;

    public Integer getIdVent() { return idVent; }
    public void setIdVent(Integer idVent) { this.idVent = idVent; }
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public List<Funcion> getFuncion() { return funcion; }
    public void setFuncion(List<Funcion> funcion) { this.funcion = funcion; }
    public List<Cliente> getCliente() { return cliente; }
    public void setCliente(List<Cliente> cliente) { this.cliente = cliente; }
}
