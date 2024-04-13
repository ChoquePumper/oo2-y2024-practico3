package oop2.tp3.ejercicio1.libros;

import oop2.tp3.ejercicio1.Libro;

public class Infantil extends Libro {
	public Infantil(String nombre) {
		super(nombre);
	}

	@Override
	public double monto(int diasAlquilados) {
		double monto = 1.5;
		if (diasAlquilados > 3)
			monto += (diasAlquilados - 3) * 1.5;
		return monto;
	}
}
