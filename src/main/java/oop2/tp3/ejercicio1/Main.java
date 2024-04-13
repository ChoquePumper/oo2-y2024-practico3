package oop2.tp3.ejercicio1;

import oop2.tp3.ejercicio1.libros.Regular;

public class Main {
    public static void main(String args[]) {
        Libro elTunel = new Regular("El Túnel");
        Libro antesDelFin = new Regular("Antes del Fin");
        CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
        CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);
        Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
        Alquiler alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);
        Cliente yo = new Cliente("Javier");
        yo.alquilar(alquilerElTunel);
        yo.alquilar(alquilerAntesDelFin);
        Object[] resultado = yo.calcularDeudaYPuntosObtenidos();
        System.out.println(resultado[0]);
        System.out.println(resultado[1]);
    }
}