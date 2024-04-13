package oop2.tp3.ejercicio1.libros;

import oop2.tp3.ejercicio1.Libro;

public class NuevoLanzamiento extends Libro {
	public NuevoLanzamiento(String nombre) {
		super(nombre);
	}

	@Override
	public double monto(int diasAlquilados) {
		return diasAlquilados * 3;
	}

	@Override
	public int puntos(int diasAlquilados) {
		return super.puntos(diasAlquilados) + (diasAlquilados > 1 ? 1 : 0);
	}
}
