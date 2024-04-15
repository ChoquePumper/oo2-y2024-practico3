package oop2.tp3.ejercicio1.libros;

import oop2.tp3.ejercicio1.Libro;

public class NuevoLanzamiento extends Libro {
	private static final double MONTO_ALQUILER_LIBRO_NUEVO_LANZAMIENTO = 3;
	private static final int MAX_DIAS_SIN_PUNTO_EXTRA = 1;

	public NuevoLanzamiento(String nombre) {
		super(nombre);
	}

	@Override
	public double monto(int diasAlquilados) {
		return diasAlquilados * MONTO_ALQUILER_LIBRO_NUEVO_LANZAMIENTO;
	}

	@Override
	public int puntos(int diasAlquilados) {
		return super.puntos(diasAlquilados) + (diasAlquilados > MAX_DIAS_SIN_PUNTO_EXTRA ? 1 : 0);
	}
}
