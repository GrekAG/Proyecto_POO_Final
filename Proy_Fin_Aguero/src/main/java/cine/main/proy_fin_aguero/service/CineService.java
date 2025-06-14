package cine.main.proy_fin_aguero.service;

import cine.main.proy_fin_aguero.dto.CompraDTO;
import cine.main.proy_fin_aguero.exception.AsientoOcupadoException;
import cine.main.proy_fin_aguero.modelo.*;
import cine.main.proy_fin_aguero.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CineService {

    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EntradaRepository entradaRepository;
    @Autowired
    private FuncionRepository funcionRepository;
    @Autowired
    private VentaRepository ventaRepository;

    public List<Pelicula> obtenerTodasLasPeliculas() {
        return peliculaRepository.findAll();
    }

    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }

    @Transactional
    public Venta realizarCompra(CompraDTO compraDTO) {

        double precioNumerico;
        if ("Sala Comun - $5000".equals(compraDTO.getPrecio())) {
            precioNumerico = 5000.0;
        } else if ("Sala VIP - $7000".equals(compraDTO.getPrecio())) {
            precioNumerico = 7000.0;
        } else {
            throw new IllegalArgumentException("Precio o tipo de sala no válido: " + compraDTO.getPrecio());
        }
        boolean asientoOcupado = funcionRepository.existeAsientoOcupado(
                compraDTO.getPeliculaTitulo(),
                compraDTO.getHorario(),
                compraDTO.getAsiento(),
                precioNumerico
        );

        if (asientoOcupado) {
            throw new AsientoOcupadoException("El asiento " + compraDTO.getAsiento() + " ya no está disponible para esta función.");
        }
        Pelicula pelicula = peliculaRepository.findById(compraDTO.getPeliculaTitulo())
                .orElseThrow(() -> new RuntimeException("Película no encontrada"));

        Cliente cliente = new Cliente(compraDTO.getNombreCli(), compraDTO.getCorreoCli());

        Entrada entrada = new Entrada();
        entrada.setAsiento(compraDTO.getAsiento());
        if ("Sala Comun - $5000".equals(compraDTO.getPrecio())) {
            entrada.setPrecio(precioNumerico);
        } else {
            entrada.setPrecio(precioNumerico);
        }

        Funcion funcion = new Funcion();
        funcion.setHorario(compraDTO.getHorario());
        funcion.setPelicula(pelicula);
        List<Entrada> entradas = new ArrayList<>();
        entradas.add(entrada);
        funcion.setEntradas(entradas);

        Venta venta = new Venta();
        venta.setFecha(new Date());

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);
        venta.setCliente(clientes);

        List<Funcion> funciones = new ArrayList<>();
        funciones.add(funcion);
        venta.setFuncion(funciones);

        return ventaRepository.save(venta);
    }

    public List<Venta> obtenerReservasPorPelicula(String peliculaTitulo) {
        Venta ventaEjemplo = new Venta();
        Funcion funcionEjemplo = new Funcion();
        Pelicula peliculaEjemplo = new Pelicula();
        peliculaEjemplo.setTitulo(peliculaTitulo);
        funcionEjemplo.setPelicula(peliculaEjemplo);
        ventaEjemplo.setFuncion(List.of(funcionEjemplo));

        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withIgnorePaths("idVent", "fecha", "cliente", "funcion.idFun", "funcion.entradas", "funcion.ventas"); // Ignorar campos irrelevantes
        Example<Venta> example = Example.of(ventaEjemplo, matcher);

        return ventaRepository.findAll(example);
    }
}
