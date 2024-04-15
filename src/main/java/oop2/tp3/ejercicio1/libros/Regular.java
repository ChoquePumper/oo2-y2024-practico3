package oop2.tp3.ejercicio1.libros;

import oop2.tp3.ejercicio1.Libro;

public class Regular extends Libro {
	private static final double MONTO_ALQUILER_LIBRO_REGULAR = 2;
	private static final int MAX_DIAS_SIN_MONTO_EXTRA = 2;
	private static final double MONTO_EXTRA_LIBRO_REGULAR = 1.5;

	public Regular(String nombre) {
		super(nombre);
	}

	@Override
	public double monto(int diasAlquilados) {
		double monto = MONTO_ALQUILER_LIBRO_REGULAR;
		if (diasAlquilados > MAX_DIAS_SIN_MONTO_EXTRA)
			monto += (diasAlquilados - MAX_DIAS_SIN_MONTO_EXTRA) * MONTO_EXTRA_LIBRO_REGULAR;
		return monto;
	}

}
