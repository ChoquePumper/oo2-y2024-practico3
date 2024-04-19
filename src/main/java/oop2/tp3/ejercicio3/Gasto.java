package oop2.tp3.ejercicio3;

import java.util.List;
import java.util.stream.Stream;

public abstract class Gasto {
    private final int monto;

    public Gasto(int monto) {
        this.monto = monto;
    }

    protected abstract String getNombre();

    public int getMonto() {
        return monto;
    }

    void soloComidas(List<Gasto> gastos) {
        protectedSoloComidas(gastos);
    }

    protected void protectedSoloComidas(List<Gasto> gastos) {
    }

    @Override
    public String toString() {
        List<String> lista = List.of(getNombre(), Integer.toString(getMonto()));
        lista = Stream.concat(lista.stream(), getStrings().stream()).toList();
        return String.join("\t", lista);
    }

    protected List<String> getStrings() {
        return List.of();
    }
}
