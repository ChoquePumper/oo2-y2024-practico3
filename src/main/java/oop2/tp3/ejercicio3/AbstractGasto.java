package oop2.tp3.ejercicio3;

import java.util.List;

// TODO: renombrar clase para reemplazar a la otra en ReporteDeGastos.
public abstract class AbstractGasto {
    private final int monto;

    public AbstractGasto(int monto) {
        this.monto = monto;
    }

    public int getMonto() {
        return monto;
    }
    
    void soloComidas(List<AbstractGasto> gastos) {
        protectedSoloComidas(gastos);
    }

    protected void protectedSoloComidas(List<AbstractGasto> gastos) {
    }
}
