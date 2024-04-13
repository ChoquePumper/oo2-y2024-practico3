package oop2.tp3.ejercicio1;

public class CopiaLibro {
    private Libro libro;

    public CopiaLibro(Libro libro) {
        this.libro = libro;
    }

    public Libro libro() {
        return libro;
    }

    public double calcularMonto(int diasAlquilados) {
        return libro.monto(diasAlquilados);
    }

    public int calcularPuntos(int diasAlquilados) {
        return libro.puntos(diasAlquilados);
    }
}