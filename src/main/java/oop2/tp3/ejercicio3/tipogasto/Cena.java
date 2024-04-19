package oop2.tp3.ejercicio3.tipogasto;

public class Cena extends GastoComida {
    public Cena(int monto) {
        super(monto);
    }

    @Override
    boolean enExceso() {
        return getMonto() > 5000;
    }

    @Override
    protected String getNombre() {
        return "Cena";
    }
}
