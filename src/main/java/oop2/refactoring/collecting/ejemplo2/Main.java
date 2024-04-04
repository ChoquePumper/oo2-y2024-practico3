package oop2.refactoring.collecting.ejemplo2;

public class Main {

    public static void main(String[] args) {
        Figura circulo = new Circulo();
        Figura hexa = new Hexagono();
        Figura rec = new Rectangulo();
        Figura circulo2 = new Circulo();

        Figuras fs = new Figuras(circulo, hexa, rec, circulo2);
        fs.dibujarLosCirculos();
    }
}
