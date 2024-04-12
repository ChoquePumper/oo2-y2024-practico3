package oop2.tp3.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class CalculoDePago {

	private static Iterable<Integer> rango(int n) {
		return () -> IntStream.range(0, n).iterator();
	}

	CopiaLibro[] setupA(int nCopiasRegular, int nCopiasNuevo, int nCopiasInfantil) {
		Libro libroRegular = new Libro("LibroRegular", Libro.REGULARES);
		Libro libroNuevo = new Libro("LibroNuevo", Libro.NUEVO_LANZAMIENTO);
		Libro libroInfantil = new Libro("LibroInfantil", Libro.INFANTILES);

		ArrayList<CopiaLibro> copias = new ArrayList<>();

		for (int i : rango(nCopiasRegular))
			copias.add(new CopiaLibro(libroRegular));
		for (int i : rango(nCopiasNuevo))
			copias.add(new CopiaLibro(libroNuevo));
		for (int i : rango(nCopiasInfantil))
			copias.add(new CopiaLibro(libroInfantil));

		return copias.toArray(new CopiaLibro[nCopiasRegular + nCopiasNuevo + nCopiasInfantil]);
	}

	// Monto regular: 2
	//                2 + (dias-2) * 1.5  si  dias > 2
	// Monto nuevo lanzamiento: dias * 3
	// Monto infantil: 1.5
	//                 1.5 + (dias-3) * 1.5  si  dias > 3
	// Puntos: 1 por alquiler, 1 extra por nuevo lanzamiento y dias > 1

	@Test
	void regular() {
		CopiaLibro[] copias = setupA(3, 0, 0);

		Cliente cliente = new Cliente("Sujeto de prueba");

		// Monto: 2 + 3*1.5 = 6.5   Puntos: 1
		cliente.alquilar(new Alquiler(copias[0], 5));
		// Monto: 2 + 8*1.5 = 14    Puntos: 1
		cliente.alquilar(new Alquiler(copias[1], 10));
		// Monto: 2                 Puntos: 1
		cliente.alquilar(new Alquiler(copias[2], 2));
		// Total: 6.5 + 14 + 2 = 22.5
		Object[] datos = cliente.calcularDeudaYPuntosObtenidos();
		double deuda = (double) datos[0];
		int puntos = (int) datos[1];
		assertEquals(22.5, deuda);
		assertEquals(3, puntos);
	}

	@Test
	void nuevoLanzamiento() {
		CopiaLibro[] copias = setupA(0, 3, 0);

		Cliente cliente = new Cliente("Sujeto de prueba");

		// Monto: 3*1 = 3   Puntos: 1
		cliente.alquilar(new Alquiler(copias[0], 1));
		// Monto: 3*2 = 6   Puntos: 2
		cliente.alquilar(new Alquiler(copias[1], 2));
		// Monto: 3*7 = 21  Puntos: 2
		cliente.alquilar(new Alquiler(copias[2], 7));
		// Total: 3 + 6 + 21 = 30

		Object[] datos = cliente.calcularDeudaYPuntosObtenidos();
		double deuda = (double) datos[0];
		int puntosAlquilerFrecuente = (int) datos[1];
		assertEquals(30, deuda);
		assertEquals(5, puntosAlquilerFrecuente);
	}

	@Test
	void infantil() {
		CopiaLibro[] copias = setupA(0, 0, 5);

		Cliente cliente = new Cliente("Sujeto de prueba");

		// Monto: 1.5   Puntos: 1
		cliente.alquilar(new Alquiler(copias[0], 1));
		// Monto: 1.5   Puntos: 2
		cliente.alquilar(new Alquiler(copias[1], 2));
		// Monto: 1.5   Puntos: 3
		cliente.alquilar(new Alquiler(copias[2], 3));
		// Monto: 1.5 + 1*1.5 = 3.0     Puntos: 4
		cliente.alquilar(new Alquiler(copias[3], 4));
		// Monto: 1.5 + 6*1.5 = 10.5     Puntos: 5
		cliente.alquilar(new Alquiler(copias[4], 9));
		// Total: 1.5*3 + 3.0 + 10.5 = 18.0

		Object[] datos = cliente.calcularDeudaYPuntosObtenidos();
		double deuda = (double) datos[0];
		int puntosAlquilerFrecuente = (int) datos[1];
		assertEquals(18.0, deuda);
		assertEquals(5, puntosAlquilerFrecuente);
	}

	@Test
	void mixto() {
		final int nRegular = 2, nNuevo = 3, nInfantil = 2;
		CopiaLibro[] copias = setupA(nRegular, nNuevo, nInfantil);

		Cliente cliente = new Cliente("Sujeto de prueba con muchos libros");

		Integer[] diasAlquiladosPorCopia = {
				2, 10,      // Regular
				1, 20, 6,   // Nuevo lanzamiento
				9, 7,       // Infantil
		};
		var indices = IntStream.range(0, nRegular + nNuevo + nInfantil);

		indices.mapToObj((i) -> new Alquiler(copias[i], diasAlquiladosPorCopia[i])).forEach(cliente::alquilar);

		// Regular: monto = 2 + (2+8*1.5) = 2 + 2+12 = 16       puntos = 2
		// Nuevo: monto = 1*3 + 20*3 + 6*3 =  3 + 60 + 18 = 81  puntos = 3 + 2
		// Infantil: monto = (1.5+6*1.5) + (1.5+4*1.5) = 18     puntos = 2

		Object[] datos = cliente.calcularDeudaYPuntosObtenidos();
		double deuda = (double) datos[0];
		int puntosAlquilerFrecuente = (int) datos[1];
		assertEquals(16 + 81 + 18, deuda);
		assertEquals(2 + 5 + 2, puntosAlquilerFrecuente);
	}

	@Test
	void nombre() {
		assertEquals("Nombre del libro", new Libro("Nombre del libro", 0).nombre());
	}
}
