package oop2.tp3.ejercicio3.tipogasto;

import oop2.tp3.ejercicio3.Gasto;

import java.util.List;

public abstract class GastoComida extends Gasto {
    public GastoComida(int monto) {
        super(monto);
    }

    abstract boolean enExceso();

    @Override
    protected void protectedSoloComidas(List<Gasto> gastos) {
        gastos.add(this);
    }

    @Override
    protected List<String> getStrings() {
        return List.of(enExceso() ? "X" : " ");
    }
}
