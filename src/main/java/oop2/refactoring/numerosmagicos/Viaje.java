package oop2.refactoring.numerosmagicos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Viaje {
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private double distanciaRecorrida;
    public double costoDelViaje() {
        if (horaSalida.getHour() > 22 || horaSalida.getHour() < 06) {
            return distanciaRecorrida * 5;
        } else {
            return distanciaRecorrida * 3;
        }
    }
}
