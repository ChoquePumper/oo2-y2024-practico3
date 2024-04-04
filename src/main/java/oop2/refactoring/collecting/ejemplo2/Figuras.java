package oop2.refactoring.collecting.ejemplo2;

import java.util.List;

public class Figuras {

    private List<Figura> figuras;

    public Figuras(Figura... figuras) {
        this.figuras = List.of(figuras);
    }

    public void dibujarLosCirculos() {
        for (Figura figura : this.figuras) {
            if (figura instanceof Circulo) {
                figura.dibujar();
            }
        }
    }

//    private List<Figura> circulos() {
//        var temp = new ArrayList<Figura>();
//        for (Figura figura : this.figuras) {
//            figura.soloCirculos(temp);
//        }
//        return temp;
//    }
}
