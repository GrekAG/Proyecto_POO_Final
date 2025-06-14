package cine.main.proy_fin_aguero.controller;

import cine.main.proy_fin_aguero.dto.CompraDTO;
import cine.main.proy_fin_aguero.exception.AsientoOcupadoException;
import cine.main.proy_fin_aguero.modelo.Pelicula;
import cine.main.proy_fin_aguero.modelo.Venta;
import cine.main.proy_fin_aguero.service.CineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cine")
public class CineController {

    @Autowired
    private CineService cineService;

    // Endpoint para obtener todas las películas
    @GetMapping("/peliculas")
    public ResponseEntity<List<Pelicula>> getPeliculas() {
        List<Pelicula> peliculas = cineService.obtenerTodasLasPeliculas();
        return new ResponseEntity<>(peliculas, HttpStatus.OK);
    }

    // Endpoint para realizar una compra
    @PostMapping("/comprar")
    public ResponseEntity<Venta> comprarEntrada(@RequestBody CompraDTO compraDTO) {
        try {
            Venta nuevaVenta = cineService.realizarCompra(compraDTO);
            return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
        } catch (Exception e) {
            // Devolvemos un error si algo sale mal (ej: película no encontrada)
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para ver todas las ventas (útil para verificar)
    @GetMapping("/ventas")
    public ResponseEntity<List<Venta>> getVentas() {
        List<Venta> ventas = cineService.obtenerTodasLasVentas();
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping("/reservas")
    public ResponseEntity<List<Venta>> getReservasPorPelicula(@RequestParam String pelicula) {
        List<Venta> reservas = cineService.obtenerReservasPorPelicula(pelicula);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @ExceptionHandler(AsientoOcupadoException.class)
    public ResponseEntity<String> handleAsientoOcupado(AsientoOcupadoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
