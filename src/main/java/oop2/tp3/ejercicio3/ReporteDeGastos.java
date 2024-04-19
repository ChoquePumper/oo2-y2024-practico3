package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReporteDeGastos {

    private final List<Gasto> gastos;
    private int total = 0, gastosDeComida = 0;
    private final LocalDate fecha;

    public ReporteDeGastos(List<Gasto> gastos) {
        this.gastos = List.copyOf(gastos);
        this.fecha = LocalDate.now();
        calcular();
    }

    private List<Gasto> soloComidas() {
        List<Gasto> comidas = new ArrayList<>();
        this.gastos.forEach(g -> g.soloComidas(comidas));
        return comidas;
    }

    private int sumarMonto(List<Gasto> lista) {
        return lista.stream().map(g -> g.getMonto()).reduce(Integer::sum).orElse(0);
    }

    private void calcular() {
        total = sumarMonto(this.gastos);
        gastosDeComida = sumarMonto(soloComidas());
    }

    public void imprimir() {
        System.out.println("Expenses " + fecha);
        for (Gasto gasto : gastos)
            imprimirGasto(gasto);
        System.out.println("Gastos de comida: " + gastosDeComida);
        System.out.println("Total de gastos: " + total);
    }

    private void imprimirGasto(Gasto gasto) {
        System.out.println(gasto);
    }

    public int verGastoTotal() {
        return this.total;
    }

    public int verGastosDeComida() {
        return this.gastosDeComida;
    }
}
