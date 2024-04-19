package oop2.tp3.ejercicio3;

import java.util.List;

import oop2.tp3.ejercicio3.tipogasto.Desayuno;

public class EjemploDeUsoDelReporte {
    public static void main(String[] args) {
        var g1 = new Desayuno(1000);
        var reporte = new ReporteDeGastos(List.of(g1));
        reporte.imprimir();
    }
}
