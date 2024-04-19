package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.List;

enum TipoDeGasto {
    CENA, DESAYUNO, ALQUILER_AUTO
}

class Gasto {
    TipoDeGasto tipoGasto;
    int monto;
    boolean marcaExcesoComidas;
}

public class ReporteDeGastos {

    private final List<Gasto> gastos;
    private int total = 0, gastosDeComida = 0;
    private final LocalDate fecha;

    public ReporteDeGastos(List<Gasto> gastos) {
        this.gastos = List.copyOf(gastos);
        this.fecha = LocalDate.now();
        calcular();
    }

    private void calcular() {
        total = 0;
        gastosDeComida = 0;

        for (Gasto gasto : gastos) {
            if (gasto.tipoGasto == TipoDeGasto.CENA || gasto.tipoGasto == TipoDeGasto.DESAYUNO) {
                gastosDeComida += gasto.monto;
            }

            gasto.marcaExcesoComidas = gasto.tipoGasto == TipoDeGasto.CENA && gasto.monto > 5000
                    || gasto.tipoGasto == TipoDeGasto.DESAYUNO && gasto.monto > 1000;

            total += gasto.monto;
        }

    }

    public void imprimir() {
        System.out.println("Expenses " + fecha);
        for (Gasto gasto : gastos) imprimirGasto(gasto);
        System.out.println("Gastos de comida: " + gastosDeComida);
        System.out.println("Total de gastos: " + total);
    }

    private void imprimirGasto(Gasto gasto) {
        String nombreGasto = "";
        switch (gasto.tipoGasto) {
            case CENA:
                nombreGasto = "Cena";
                break;
            case DESAYUNO:
                nombreGasto = "Desayuno";
                break;
            case ALQUILER_AUTO:
                nombreGasto = "Alquiler de Autos";
                break;
        }
        String marcaExcesoComidas = gasto.marcaExcesoComidas ? "X" : " ";
        System.out.println(nombreGasto + "\t" + gasto.monto + "\t" + marcaExcesoComidas);
    }
}
