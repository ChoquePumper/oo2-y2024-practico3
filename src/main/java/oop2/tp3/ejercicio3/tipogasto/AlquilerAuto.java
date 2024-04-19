package oop2.tp3.ejercicio3.tipogasto;

import oop2.tp3.ejercicio3.Gasto;

public class AlquilerAuto extends Gasto {
    public AlquilerAuto(int monto) {
        super(monto);
    }

    @Override
    protected String getNombre() {
        return "Alquiler auto";
    }
}
