package oop2.tp3.ejercicio3.tipogasto;

public class Desayuno extends GastoComida {
    public Desayuno(int monto) {
        super(monto);
    }

    @Override
    boolean enExceso() {
        return getMonto() > 1000;
    }

    @Override
    protected String getNombre() {
        return "Desayuno";
    }
}
