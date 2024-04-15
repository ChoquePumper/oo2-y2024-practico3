package oop2.tp3.ejercicio2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {
    public static List<Map<String, String>> where(Map<String, String> options)
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
