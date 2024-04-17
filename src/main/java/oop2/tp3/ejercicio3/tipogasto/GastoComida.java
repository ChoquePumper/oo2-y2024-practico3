package oop2.tp3.ejercicio3.tipogasto;

import oop2.tp3.ejercicio3.AbstractGasto;

public abstract class GastoComida extends AbstractGasto {
    public GastoComida(int monto) {
        super(monto);
    }

    abstract boolean enExceso();
}
