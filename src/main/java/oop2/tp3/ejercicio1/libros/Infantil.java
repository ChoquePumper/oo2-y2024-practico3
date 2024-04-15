package oop2.tp3.ejercicio1.libros;

import oop2.tp3.ejercicio1.Libro;

public class Infantil extends Libro {
	private static final double MONTO_ALQUILER_LIBRO_INFANTIL = 1.5;
	private static final int MAX_DIAS_SIN_MONTO_EXTRA = 3;
	private static final double MONTO_EXTRA_LIBRO_INFANTIL = 1.5;

	public Infantil(String nombre) {
		super(nombre);
	}

	@Override
	public double monto(int diasAlquilados) {
		double monto = MONTO_ALQUILER_LIBRO_INFANTIL;
		if (diasAlquilados > MAX_DIAS_SIN_MONTO_EXTRA)
			monto += (diasAlquilados - MAX_DIAS_SIN_MONTO_EXTRA) * MONTO_EXTRA_LIBRO_INFANTIL;
		return monto;
	}
}
