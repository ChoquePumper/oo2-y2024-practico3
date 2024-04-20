package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GastosTest {

    // TODO: Este método sera removido cuando termine de refactorizar el modelo.
    @Deprecated(forRemoval = true)
    private static Gasto nuevoGasto(int monto, TipoDeGasto tipo) {
        var g = new Gasto();
        g.tipoGasto = tipo;
        g.monto = monto;
        return g;
    }

    static Gasto gastoDesayuno(int monto) {
        return nuevoGasto(monto, TipoDeGasto.DESAYUNO);
    }

    static Gasto gastoCena(int monto) {
        return nuevoGasto(monto, TipoDeGasto.CENA);
    }

    static Gasto gastoAlquilerAuto(int monto) {
        return nuevoGasto(monto, TipoDeGasto.ALQUILER_AUTO);
    }

    @Test
    void delEjemplo() {
        var g1 = gastoDesayuno(1000);
        var reporte = new ReporteDeGastos(List.of(g1));
        assertEquals(1000, reporte.verGastoTotal());
        assertEquals(1000, reporte.verGastosDeComida());
        assertFalse(g1.marcaExcesoComidas);
    }

    @Test
    void testDesayuno() {
        var gasto1 = gastoDesayuno(1000);
        var gasto2 = gastoDesayuno(1001);
        var reporte = new ReporteDeGastos(List.of(gasto1, gasto2));

        assertFalse(gasto1.marcaExcesoComidas);
        assertTrue(gasto2.marcaExcesoComidas);

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

        assertFalse(gastos.get(0).marcaExcesoComidas);
        assertFalse(gastos.get(1).marcaExcesoComidas);
        assertFalse(gastos.get(2).marcaExcesoComidas);
        assertTrue(gastos.get(3).marcaExcesoComidas);
        assertFalse(gastos.get(4).marcaExcesoComidas);

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

        assertFalse(gastos.get(0).marcaExcesoComidas);
        assertFalse(gastos.get(1).marcaExcesoComidas);
        assertFalse(gastos.get(2).marcaExcesoComidas);

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

        assertFalse(gastos.get(0).marcaExcesoComidas);
        assertTrue(gastos.get(1).marcaExcesoComidas);
        assertFalse(gastos.get(2).marcaExcesoComidas);

        assertEquals(26339, reporte.verGastoTotal());
        assertEquals(9739, reporte.verGastosDeComida());
    }
}
