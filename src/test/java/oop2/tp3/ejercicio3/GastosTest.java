package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import oop2.tp3.ejercicio3.tipogasto.AlquilerAuto;
import oop2.tp3.ejercicio3.tipogasto.Cena;
import oop2.tp3.ejercicio3.tipogasto.Desayuno;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GastosTest {

    static Gasto gastoDesayuno(int monto) {
        return new Desayuno(monto);
    }

	static Gasto gastoCena(int monto) {
        return new Cena(monto);
    }

	static Gasto gastoAlquilerAuto(int monto) {
        return new AlquilerAuto(monto);
    }

    @Test
    void delEjemplo() {
        var g1 = gastoDesayuno(1000);
        var reporte = new ReporteDeGastos(List.of(g1));
        assertEquals(1000, reporte.verGastoTotal());
        assertEquals(1000, reporte.verGastosDeComida());
    }

    @Test
    void testDesayuno() {
        var gasto1 = gastoDesayuno(1000);
        var gasto2 = gastoDesayuno(1001);
        var reporte = new ReporteDeGastos(List.of(gasto1, gasto2));

        assertEquals(2001, reporte.verGastoTotal());
        assertEquals(2001, reporte.verGastosDeComida());
    }

    @Test
    void testCena() {
        var gastos = List.of(
                gastoCena(1000),
                gastoCena(2000),
                gastoCena(4000),
                gastoCena(5001),
                gastoCena(5000));
        var reporte = new ReporteDeGastos(gastos);

        assertEquals(17001, reporte.verGastoTotal());
        assertEquals(17001, reporte.verGastosDeComida());
    }

    @Test
    void testAlquilerAuto() {
        var gastos = List.of(
                gastoAlquilerAuto(4000),
                gastoAlquilerAuto(27003),
                gastoAlquilerAuto(12345));
        var reporte = new ReporteDeGastos(gastos);

        assertEquals(43348, reporte.verGastoTotal());
        assertEquals(0, reporte.verGastosDeComida());
    }

    @Test
    void testMixto() {
        var gastos = List.of(
                gastoDesayuno(789),
                gastoCena(8950),
                gastoAlquilerAuto(16600));
        var reporte = new ReporteDeGastos(gastos);

        assertEquals(26339, reporte.verGastoTotal());
        assertEquals(9739, reporte.verGastosDeComida());
    }
}
