package oop2.tp3.ejercicio3.tipogasto;

import oop2.tp3.ejercicio3.AbstractGasto;

import java.util.List;

public abstract class GastoComida extends AbstractGasto {
    public GastoComida(int monto) {
        super(monto);
    }

    abstract boolean enExceso();

    @Override
    protected void protectedSoloComidas(List<AbstractGasto> gastos) {
        gastos.add(this);
    }
}
