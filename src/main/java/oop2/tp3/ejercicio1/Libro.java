package oop2.tp3.ejercicio1;

public abstract class Libro {
    public static final int INFANTILES = 2;
    public static final int REGULARES = 0;
    public static final int NUEVO_LANZAMIENTO = 1;
    private String nombre;
    private int codigoPrecio;

    public Libro(String nombre) {
        this.nombre = nombre;
    }

    public int codigoPrecio() {
        return 0;
    }

    public String nombre() {
        return nombre;
    }

    public abstract double monto(int diasAlquilados);

    public int puntos(int diasAlquilados) {
        return 1;
    }


}