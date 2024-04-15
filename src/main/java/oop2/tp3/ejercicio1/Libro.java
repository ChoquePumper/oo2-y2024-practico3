package oop2.tp3.ejercicio1;

public abstract class Libro {
    private static final int PUNTOS_POR_ALQUILER = 1;
    private String nombre;

    public Libro(String nombre) {
        this.nombre = nombre;
    }

    public String nombre() {
        return nombre;
    }

    public abstract double monto(int diasAlquilados);

    public int puntos(int diasAlquilados) {
        return PUNTOS_POR_ALQUILER;
    }


}