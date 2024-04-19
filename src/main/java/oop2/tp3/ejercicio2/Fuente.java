package oop2.tp3.ejercicio2;

import java.util.Map;
import java.util.NoSuchElementException;

public interface Fuente extends Iterable<Map<String, String>> {

    Map<String, String> leerSiguiente() throws NoSuchElementException;

}