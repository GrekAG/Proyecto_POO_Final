document.addEventListener('DOMContentLoaded', () => {
    const path = window.location.pathname;

    if (path === '/' || path === '/index.html') {
        cargarPeliculas();
    } else if (path === '/comprar.html') {
        configurarFormularioCompra();
    }
});

function cargarPeliculas() {
    fetch('/api/cine/peliculas')
        .then(response => response.json())
        .then(peliculas => {
            const carteleraDiv = document.getElementById('cartelera');
            carteleraDiv.innerHTML = ''; // Limpiar
            peliculas.forEach(pelicula => {
                const card = document.createElement('div');
                card.className = 'pelicula-card';
                card.innerHTML = `
                    <h3>${pelicula.titulo}</h3>
                    <p>Género: ${pelicula.genero}</p>
                `;
                card.onclick = () => {
                    window.location.href = `/comprar.html?pelicula=${encodeURIComponent(pelicula.titulo)}`;
                };
                carteleraDiv.appendChild(card);
            });
        })
        .catch(error => console.error('Error al cargar películas:', error));
}

function configurarFormularioCompra() {
    const params = new URLSearchParams(window.location.search);
    const peliculaTitulo = params.get('pelicula');

    if (peliculaTitulo) {
        document.getElementById('titulo-pelicula').innerText = peliculaTitulo;
        cargarReservas(peliculaTitulo); // Cargar las reservas al configurar el formulario
    }

    const form = document.getElementById('form-compra');
    form.addEventListener('submit', (event) => {
        event.preventDefault();

        const compraData = {
            nombreCli: document.getElementById('txtNombreCliente').value,
            correoCli: document.getElementById('txtCorreoCliente').value,
            asiento: document.getElementById('cmbAsiento').value,
            horario: document.getElementById('cmbHorario').value,
            precio: document.getElementById('cmbSalaPrecio').value,
            peliculaTitulo: peliculaTitulo
        };

        fetch('/api/cine/comprar', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(compraData)
        })
            .then(response => {
                if (!response.ok) {
                    return response.text().then(text => { throw new Error(text) });
                }
                return response.json();
            })
            .then(data => {
                console.log('Compra exitosa:', data);
                const mensajeExito = document.getElementById('mensaje-exito');
                mensajeExito.textContent = '¡Compra realizada con éxito!';
                form.reset();
                setTimeout(() => mensajeExito.textContent = '', 3000);
                cargarReservas(peliculaTitulo); // Recargar las reservas después de una compra
            })
            .catch(error => {
                console.error('Error:', error);
                const mensajeExito = document.getElementById('mensaje-exito');
                mensajeExito.textContent = 'Hubo un error al procesar la compra. Inténtalo de nuevo.';
                mensajeExito.style.color = '#e50914';
            });
    });
}

function cargarReservas(peliculaTitulo) {
    fetch(`/api/cine/reservas?pelicula=${encodeURIComponent(peliculaTitulo)}`)
        .then(response => response.json())
        .then(reservas => {
            const tbody = document.getElementById('tabla-reservas').getElementsByTagName('tbody')[0];
            tbody.innerHTML = ''; // Limpiar la tabla

            reservas.forEach(venta => {
                venta.funcion.forEach(funcion => {
                    if (funcion.pelicula.titulo === peliculaTitulo) {
                        funcion.entradas.forEach(entrada => {
                            venta.cliente.forEach(cliente => {
                                const row = tbody.insertRow();
                                const idCell = row.insertCell();
                                const fechaCell = row.insertCell();
                                const peliculaCell = row.insertCell();
                                const horarioCell = row.insertCell();
                                const asientoCell = row.insertCell();
                                const clienteCell = row.insertCell();
                                const precioCell = row.insertCell();

                                idCell.textContent = venta.idVent;
                                fechaCell.textContent = new Date(venta.fecha).toLocaleString();
                                peliculaCell.textContent = funcion.pelicula.titulo;
                                horarioCell.textContent = funcion.horario;
                                asientoCell.textContent = entrada.asiento;
                                clienteCell.textContent = cliente.nombre;
                                precioCell.textContent = entrada.precio;
                            });
                        });
                    }
                });
            });
        })
        .catch(error => console.error('Error al cargar las reservas:', error));
}