package oop2.tp3.ejercicio3.tipogasto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GastoEnExcesoTest {

    @Test
    void enExceso() {
        GastoComida[] gastosEnExceso = {
                new Desayuno(1001),
                new Desayuno(9999),
                new Cena(5001),
                new Cena(22222),
        };
        for (var gasto : gastosEnExceso)
            assertTrue(gasto.enExceso());

        GastoComida[] gastosNoEnExceso = {
                new Desayuno(1000),
                new Desayuno(12),
                new Cena(5000),
                new Cena(123),
        };
        for (var gasto : gastosNoEnExceso)
            assertFalse(gasto.enExceso());
    }
}
