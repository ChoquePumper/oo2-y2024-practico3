package oop2.tp3.ejercicio3;

// TODO: renombrar clase para reemplazar a la otra en ReporteDeGastos.
public abstract class AbstractGasto {
    private final int monto;

    public AbstractGasto(int monto) {
        this.monto = monto;
    }

    public int getMonto() {
        return monto;
    }
}
