package oop2.tp3.ejercicio1.libros;

import oop2.tp3.ejercicio1.Libro;

public class Regular extends Libro {
	public Regular(String nombre) {
		super(nombre);
	}

	@Override
	public double monto(int diasAlquilados) {
		double monto = 2;
		if (diasAlquilados > 2)
			monto += (diasAlquilados - 2) * 1.5;
		return monto;
	}

}
