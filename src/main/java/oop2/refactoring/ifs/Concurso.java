package oop2.refactoring.ifs;

import java.util.List;

public class Concurso {
    private List<Participante> participantes;
    public void agregarParticipante(Participante participante) throws Exception {
        if (esFechaValida()) {
            this.participantes.add(participante);
            if (esPrimerDia()) {
                participante.sumarPuntosPorInscripcion();
            }
        } else {
            throw new Exception("La fecha no es valida");
        }
    }

    private boolean esPrimerDia() {
        //se inscribe el primer día de abierta la inscripcion?
        return true;
    }

    private boolean esFechaValida() {
        //si se inscribe dentro del rango de inscripcion, true, sino false
        return false;
    }
}

class Participante {
    public void sumarPuntosPorInscripcion() {
    }
}