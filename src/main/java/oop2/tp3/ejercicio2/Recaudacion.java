package oop2.tp3.ejercicio2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
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

    public static List<Map<String, String>> where(Map<String, String> options)
            throws IOException {
        return new Recaudacion(new ArchivoCSV("src/main/resources/data.csv"))
                .filtrar(options).stream()
                .map(Registro::getMapa).toList();
    }

    public static List<Map<String, String>> whereViejo(Map<String, String> options)
            throws IOException {
        List<String[]> csvData = new ArrayList<String[]>();
        CSVReader reader = new CSVReader(new FileReader("src/main/resources/data.csv"));
        String[] row = null;

        while ((row = reader.readNext()) != null) {
            csvData.add(row);
        }

        reader.close();
        csvData.remove(0);

        if (options.containsKey("company_name")) {
            List<String[]> results = new ArrayList<String[]>();

            for (String[] csvDatum : csvData) {
                if (csvDatum[1].equals(options.get("company_name"))) {
                    results.add(csvDatum);
                }
            }
            csvData = results;
        }

        if (options.containsKey("city")) {
            List<String[]> results = new ArrayList<String[]>();

            for (String[] csvDatum : csvData) {
                if (csvDatum[4].equals(options.get("city"))) {
                    results.add(csvDatum);
                }
            }
            csvData = results;
        }

        if (options.containsKey("state")) {
            List<String[]> results = new ArrayList<String[]>();

            for (String[] csvDatum : csvData) {
                if (csvDatum[5].equals(options.get("state"))) {
                    results.add(csvDatum);
                }
            }
            csvData = results;
        }

        if (options.containsKey("round")) {
            List<String[]> results = new ArrayList<String[]>();

            for (String[] csvDatum : csvData) {
                if (csvDatum[9].equals(options.get("round"))) {
                    results.add(csvDatum);
                }
            }
            csvData = results;
        }

        List<Map<String, String>> output = new ArrayList<Map<String, String>>();

        for (String[] csvDatum : csvData) {
            Map<String, String> mapped = new HashMap<String, String>();
            mapped.put("permalink", csvDatum[0]);
            mapped.put("company_name", csvDatum[1]);
            mapped.put("number_employees", csvDatum[2]);
            mapped.put("category", csvDatum[3]);
            mapped.put("city", csvDatum[4]);
            mapped.put("state", csvDatum[5]);
            mapped.put("funded_date", csvDatum[6]);
            mapped.put("raised_amount", csvDatum[7]);
            mapped.put("raised_currency", csvDatum[8]);
            mapped.put("round", csvDatum[9]);
            output.add(mapped);
        }
        return output;
    }
}
