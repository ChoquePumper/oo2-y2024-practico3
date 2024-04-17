package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GastosTest {

    @Test
    void delEjemplo() {
        var g1 = new Gasto();
        g1.tipoGasto = TipoDeGasto.DESAYUNO;
        g1.monto = 1000;
        var reporte = new ReporteDeGastos(List.of(g1));
        assertEquals(1000, reporte.verGastoTotal());
        assertEquals(1000, reporte.verGastosDeComida());
        assertFalse(g1.marcaExcesoComidas);
    }
}
