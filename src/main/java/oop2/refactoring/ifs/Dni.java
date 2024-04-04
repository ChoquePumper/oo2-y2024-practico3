package oop2.refactoring.ifs;

public class Dni {
    private String numeroDni;

    public Dni(String dni) {
        if (dni != null) {
            if (!dni.isEmpty()) {
                if (tieneLargoCorrecto(dni)) {
                    if (todosNumeros(dni)) {
                        this.numeroDni = dni;
                    } else {
                        throw new RuntimeException("Debe ingresar números solamente");
                    }
                } else {
                    throw new RuntimeException("El largo del dni no puede ser menor a 3 ni mayor a 10");
                }
            } else {
                throw new RuntimeException("Dni no puede ser vacío");
            }
        } else {
            throw new RuntimeException("Dni no puede ser nulo");
        }
    }

    private boolean tieneLargoCorrecto(String dni) {
        return false;
    }

    private boolean todosNumeros(String dni) {
        return true;
    }
}
