package oop2.refactoring.parametros.entrada;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Disco {
    private String pathBase;

    // ¿Qué pasa si pathBase es null?
    // ¿y si el path no existe?
    // no me entero hasta no invocar guardar...
    // aseguremos objetos completos al instanciarlos
    public Disco(String pathBase) {
//        Objects.requireNonNull(pathBase);
//        Path path = Paths.get(pathBase);
//        if (Files.notExists(path)) {
//            throw new IllegalArgumentException("No existe el path...");
//        }
        this.pathBase = pathBase;
    }

    public void guardar(String nombre, String contenido) throws IOException {
        if (!pathBase.endsWith("/")) {
            nombre = "/" + nombre;
        }
        Files.write(Paths.get(pathBase + nombre), contenido.getBytes());
    }
}