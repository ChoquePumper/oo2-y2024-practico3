package oop2.refactoring.ifs;

import java.time.LocalDate;
import java.time.LocalTime;

public class Viaje {
    private static final int COEFICIENTE_VIAJE_NOCTURNO = 5;
    private static final int COEFICIENTE_VIAJE_DIURNO = 3;
    private static final int COEFICIENTE_VIAJE_DOMINGO = 4;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private double distanciaRecorrida;

    public double costoDelViaje() {
        if (esHorarioNocturno()) {
            return distanciaRecorrida * COEFICIENTE_VIAJE_NOCTURNO;
        } else {
            if (esDomingo()) {
                return distanciaRecorrida * COEFICIENTE_VIAJE_DOMINGO;
            } else {
                return distanciaRecorrida * COEFICIENTE_VIAJE_DIURNO;
            }
        }
    }

    private boolean esDomingo() {
        return true;
    }

    private boolean esHorarioNocturno() {
        return horaSalida.getHour() > 22 || horaSalida.getHour() < 06;
    }
}
