package oop2.refactoring.parametros.salida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

class Disco {
    private String pathBase;

    public Disco(String pathBase) {
        Objects.requireNonNull(pathBase);
        Path path = Paths.get(pathBase);
        if (Files.notExists(path)) {
            throw new IllegalArgumentException("No existe el path...");
        }
        this.pathBase = pathBase;
    }

    public void guardar(String nombre, String contenido) throws IOException {
        if (!pathBase.endsWith("/")) {
            nombre = "/" + nombre;
        }
        Files.write(Paths.get(pathBase + nombre), contenido.getBytes());
    }

    public String contenido(String nombre) throws IOException {
        Objects.nonNull(nombre);
        Path path = Paths.get(nombre);
        if (!Files.exists(path))
            return null;
        List<String> lineas = Files.readAllLines(path);
        return String.join(" ", lineas);
    }

//    public String contenido2(String nombre) throws IOException {
//        Objects.nonNull(nombre);
//        Path path = Paths.get(nombre);
//        if (!Files.exists(path))
//            throw new IllegalArgumentException("El nombre ingresado...");
//        List<String> lineas = Files.readAllLines(path);
//        return String.join(" ", lineas);
//    }

//    public Optional<String> contenido3(String nombre) throws IOException {
//        Objects.nonNull(nombre);
//        Path path = Paths.get(nombre);
//        if (!Files.exists(path))
//            return Optional.empty();
//        List<String> lineas = Files.readAllLines(path);
//        return Optional.of(String.join(" ", lineas));
//    }

    //¿ y que pasa con las listas? uso Optional aca?
//    public List<String> archivos() {
//
//    }
}