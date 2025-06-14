DROP DATABASE IF EXISTS proy_int;
CREATE DATABASE proy_int;
USE proy_int;

-- Tabla cine
CREATE TABLE cine (
    NOMBRE VARCHAR(255) PRIMARY KEY,
    DIRECCION VARCHAR(255)
);

-- Tabla cine_pelicula
CREATE TABLE cine_pelicula (
    Cine_NOMBRE VARCHAR(255),
    pelicula_TITULO VARCHAR(255),
    PRIMARY KEY (Cine_NOMBRE, pelicula_TITULO),
    FOREIGN KEY (Cine_NOMBRE) REFERENCES cine(NOMBRE)
);

-- Tabla cine_sala
CREATE TABLE cine_sala (
    Cine_NOMBRE VARCHAR(255),
    salas_NUMERO INT(11),
    salasVIP_NUMERO INT(11),
    PRIMARY KEY (Cine_NOMBRE, salas_NUMERO, salasVIP_NUMERO),
    FOREIGN KEY (Cine_NOMBRE) REFERENCES cine(NOMBRE)
);

-- Tabla cine_venta
CREATE TABLE cine_venta (
    Cine_NOMBRE VARCHAR(255),
    ventas_IDVENT INT(11),
    PRIMARY KEY (Cine_NOMBRE, ventas_IDVENT),
    FOREIGN KEY (Cine_NOMBRE) REFERENCES cine(NOMBRE)
);

-- Tabla cliente
CREATE TABLE cliente (
    NOMBRE VARCHAR(255) PRIMARY KEY,
    EMAIL VARCHAR(255)
);

-- Tabla entrada
CREATE TABLE entrada (
    IDENTRADA INT(11) AUTO_INCREMENT PRIMARY KEY,
    ASIENTO VARCHAR(255),
    PRECIO DOUBLE
);

-- Tabla pelicula
CREATE TABLE pelicula (
    TITULO VARCHAR(255) PRIMARY KEY,
    GENERO ENUM('accion', 'comedia', 'drama', 'suspenso')
);

-- Tabla funcion
CREATE TABLE funcion (
    IDFUN INT(11) AUTO_INCREMENT PRIMARY KEY,
    HORARIO VARCHAR(255),
    PELICULA_TITULO VARCHAR(255),
    FOREIGN KEY (PELICULA_TITULO) REFERENCES pelicula(TITULO)
);

-- Tabla funcion_entrada
CREATE TABLE funcion_entrada (
    Funcion_IDFUN INT(11),
    entradas_IDENTRADA INT(11),
    PRIMARY KEY (Funcion_IDFUN, entradas_IDENTRADA),
    FOREIGN KEY (Funcion_IDFUN) REFERENCES funcion(IDFUN),
    FOREIGN KEY (entradas_IDENTRADA) REFERENCES entrada(IDENTRADA)
);

-- Tabla sala
CREATE TABLE sala (
    NUMERO INT(11) AUTO_INCREMENT PRIMARY KEY,
    DTYPE VARCHAR(31),
    CAPACIDAD INT(11),
    BENEFICIOS VARCHAR(255)
);

-- Tabla sala_funcion
CREATE TABLE sala_funcion (
    Sala_NUMERO INT(11),
    funciones_IDFUN INT(11),
    PRIMARY KEY (Sala_NUMERO, funciones_IDFUN),
    FOREIGN KEY (Sala_NUMERO) REFERENCES sala(NUMERO),
    FOREIGN KEY (funciones_IDFUN) REFERENCES funcion(IDFUN)
);

-- Tabla venta
CREATE TABLE venta (
    IDVENT INT(11) AUTO_INCREMENT PRIMARY KEY,
    FECHA DATETIME
);

-- Tabla venta_cliente
CREATE TABLE venta_cliente (
    Venta_IDVENT INT(11),
    cliente_NOMBRE VARCHAR(255),
    PRIMARY KEY (Venta_IDVENT, cliente_NOMBRE),
    FOREIGN KEY (Venta_IDVENT) REFERENCES venta(IDVENT),
    FOREIGN KEY (cliente_NOMBRE) REFERENCES cliente(NOMBRE)
);

-- Tabla venta_funcion
CREATE TABLE venta_funcion (
    Venta_IDVENT INT(11),
    funcion_IDFUN INT(11),
    PRIMARY KEY (Venta_IDVENT, funcion_IDFUN),
    FOREIGN KEY (Venta_IDVENT) REFERENCES venta(IDVENT),
    FOREIGN KEY (funcion_IDFUN) REFERENCES funcion(IDFUN)
);

INSERT INTO proy_int.cine VALUES ('Cinemark', 'Av. San Martin 2685');

INSERT INTO proy_int.pelicula VALUES ('Shrek', 'comedia');
INSERT INTO proy_int.pelicula VALUES ('Deadpool 3', 'accion');
INSERT INTO proy_int.pelicula VALUES ('Trerrifier 3', 'suspenso');
INSERT INTO proy_int.pelicula VALUES ('Orgullo y prejuicio', 'drama');