package oop2.tp3.ejercicio2;

import java.util.*;

public class Recaudacion {
    private static final Set<String> camposRequeridos = Set.of(
            "permalink", "company_name", "number_employees", "category", "city",
            "state", "funded_date", "raised_amount", "raised_currency", "round");

    private static class Registro {
        Map<String, String> mapa;

        Registro(Map<String, String> campos) {
            this.mapa = Map.copyOf(campos);
            if (!contieneTodosLosCampos())
                throw new IllegalArgumentException("Faltan campos requeridos");
        }

        private boolean contieneTodosLosCampos() {
            return this.mapa.keySet().containsAll(camposRequeridos);
        }

        Map<String, String> getMapa() {
            return Map.copyOf(this.mapa);
        }
    }

    private List<Registro> registros;

    public Recaudacion(Fuente fuente) {
        this.registros = new ArrayList<>();
        for (var mapa : fuente)
            registros.add(new Registro(mapa));
    }

    private List<Registro> filtrar(Map<String, String> options) {
        return this.registros.stream().filter(registro -> {
            for (String campo : options.keySet())
                if (!Objects.equals(options.get(campo), registro.mapa.get(campo)))
                    return false;
            return true;
        }).toList();
    }

    public List<Map<String, String>> where(Map<String, String> options) {
        return this.filtrar(options).stream().map(Registro::getMapa).toList();
    }
}
