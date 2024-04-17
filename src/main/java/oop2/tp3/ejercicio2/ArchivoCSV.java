package oop2.tp3.ejercicio2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArchivoCSV implements Fuente {
    private final CSVReader reader;
    private final String[] columnas;

    public ArchivoCSV(String filename) throws IOException {
        this.reader = new CSVReader(new FileReader(filename));
        // Leer cabecera
        this.columnas = leerSiguienteLinea().orElseThrow();
    }

    private Optional<String[]> leerSiguienteLinea() {
        try {
            return Optional.ofNullable(this.reader.readNext());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, String> crearMapa(String[] fila) {
        return IntStream.range(0, columnas.length).boxed()
                .collect(Collectors.toMap(i -> columnas[i], i -> fila[i]));
    }

    @Override
    public Map<String, String> leerSiguiente() throws NoSuchElementException {
        String[] fila = leerSiguienteLinea().orElseThrow();
        return crearMapa(fila);
    }

    @Override
    public Iterator<Map<String, String>> iterator() {
        return new Iterator<Map<String, String>>() {

            private Optional<String[]> lineaTemp = Optional.empty();
            private boolean fin = false;

            private Optional<String[]> iterar() {
                lineaTemp = lineaTemp.or(() -> leerSiguienteLinea());
                return lineaTemp;
            }

            @Override
            public boolean hasNext() {
                if (fin)
                    return false;
                fin = iterar().isEmpty();
                return !fin;
            }

            @Override
            public Map<String, String> next() {
                var ret = iterar().map(l -> crearMapa(l)).orElseThrow();
                lineaTemp = Optional.empty();
                return ret;
            }
        };
    }

}
