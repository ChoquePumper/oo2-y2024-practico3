package oop2.tp3.ejercicio3.tipogasto;

import oop2.tp3.ejercicio3.Gasto;

import java.util.List;

public class AlquilerAuto extends Gasto {
    public AlquilerAuto(int monto) {
        super(monto);
    }

    @Override
    protected String getNombre() {
        return "Alquiler de Autos";
    }

    // Para mantener el formato del informe como era antes, agregar un espacio.
    // TODO: pensar en una mejor alternativa.
    @Override
    protected List<String> getStrings() {
        return List.of(" ");
    }
}
