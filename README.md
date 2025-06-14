## 🛠️ Tecnologías Utilizadas

-   **Backend:**
    -   Java 17
    -   Spring Boot 3
    -   Spring Web (para la API REST)
    -   Spring Data JPA (con Hibernate para la persistencia)
-   **Base de Datos:**
    -   MySQL
-   **Frontend:**
    -   HTML5
    -   CSS3 (con Grid y Flexbox para el layout)
    -   JavaScript (Vanilla JS con `fetch` para consumir la API)
-   **Build Tool:**
    -   Maven

## 📂 Estructura del Proyecto

La estructura del proyecto sigue las convenciones estándar de una aplicación Spring Boot, separando las responsabilidades en diferentes capas.

```
.
├── .gitignore
├── mvnw
├── pom.xml
└── src
    └── main
        ├── java
        │   └── cine
        │       └── main
        │           └── proy_fin_aguero
        │               ├── ProyFinAgueroApplication.java
        │               ├── controller
        │               │   └── CineController.java
        │               ├── dto
        │               │   └── CompraDTO.java
        │               ├── exception
        │               │   └── AsientoOcupadoException.java
        │               ├── modelo
        │               │   ├── Cliente.java
        │               │   ├── Entrada.java
        │               │   ├── Funcion.java
        │               │   ├── Pelicula.java
        │               │   └── Venta.java
        │               │   └── ...
        │               ├── repository
        │               │   ├── ClienteRepository.java
        │               │   ├── FuncionRepository.java
        │               │   └── ...
        │               └── service
        │                   └── CineService.java
        └── resources
            ├── static
            │   ├── css
            │   │   └── style.css
            │   ├── js
            │   │   └── app.js
            │   ├── comprar.html
            │   └── index.html
            ├── templates/
            └── application.properties
```

## 🚀 Puesta en Marcha

Sigue estos pasos para clonar y ejecutar el proyecto en tu entorno local.

### Prerrequisitos

-   Java JDK 17 o superior.
-   Maven 3.2+.
-   Git.
-   Una instancia de MySQL en ejecución.

### Pasos

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/GrekAG/Proyecto_POO_Final.git
    ```

2.  **Configurar la Base de Datos:**
    -   Abre tu cliente de MySQL y crea una nueva base de datos llamada `proy_int`.
    -   Ejecuta el script `Proy_Int_Agüero.sql` (que se encuentra en la raíz del proyecto original) para crear todas las tablas y cargar los datos iniciales.

3.  **Configurar la Aplicación:**
    -   Abre el archivo `src/main/resources/application.properties`.
    -   Asegúrate de que los valores para `spring.datasource.url`, `username` y `password` coincidan con tu configuración local de MySQL.

4.  **Compilar y Ejecutar:**
    -   Puedes ejecutar la aplicación directamente desde IntelliJ IDEA haciendo clic derecho en `ProyFinAgueroApplication.java` y seleccionando "Run".
    -   O puedes usar Maven desde la terminal:
        ```bash
        mvn spring-boot:run
        ```

5.  **Acceder a la Aplicación:**
    -   Una vez que la aplicación se haya iniciado, abre tu navegador web y ve a `http://localhost:8080`.

## 📖 Endpoints de la API

La API expone los siguientes endpoints principales:

| Método | URL                                    | Descripción                                                              |
| :----- | :------------------------------------- | :----------------------------------------------------------------------- |
| `GET`  | `/api/cine/peliculas`                  | Devuelve la lista de todas las películas disponibles.                    |
| `POST` | `/api/cine/comprar`                    | Procesa una nueva compra de entrada. Requiere un `CompraDTO` en el body. |
| `GET`  | `/api/cine/ventas-por-pelicula?titulo={titulo}` | Devuelve las ventas realizadas para una película específica.             |

## ✒️ Autor

* **Gregorio Agüero**
