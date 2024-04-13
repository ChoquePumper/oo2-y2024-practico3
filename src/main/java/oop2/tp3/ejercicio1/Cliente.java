package oop2.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<Alquiler> alquileres = new ArrayList<Alquiler>();
    private String name;

    public Cliente(String nombre) {
        this.name = nombre;
    }

    public Object[] calcularDeudaYPuntosObtenidos() {
        record Acumulador(double deuda, int puntos) {
            Acumulador suma(Acumulador otro) {
                return new Acumulador(this.deuda + otro.deuda, this.puntos + otro.puntos);
            }
        }

        var total2 = alquileres.stream()
                .map(alquiler -> new Acumulador(alquiler.monto(), alquiler.puntos()))
                .reduce(Acumulador::suma);

        return new Object[]{total2.get().deuda(), total2.get().puntos()};
    }

    public void alquilar(Alquiler rental) {
        alquileres.add(rental);
    }
}