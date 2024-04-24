package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static oop2.tp3.ejercicio3.GastosTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReporteTest {

	// TODO: eliminar este método después de refactorizar.
	private String capturarTextoDeSysOut(Runnable runnable) {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		final PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outContent));
		runnable.run();
		System.setOut(originalOut);
		return outContent.toString();
	}

	@Test
	void delEjemplo() {
		var g1 = gastoDesayuno(1000);
		var reporte = new ReporteDeGastos(List.of(g1));
		String textoDelReporte = capturarTextoDeSysOut(() -> {
					reporte.imprimir();
				}
		).stripTrailing();

		String[] lineas = {
				"'Expenses' uuuu-MM-dd", // Para DateTimeFormatter
				"Desayuno\t1000\t ",
				"Gastos de comida: 1000",
				"Total de gastos: 1000",
		};
		// La primera linea contiene la fecha de hoy.
		lineas[0] = LocalDate.now().format(DateTimeFormatter.ofPattern(lineas[0]));
		// Unir el texto
		String esperado = String.join("\n", lineas);

		assertEquals(esperado, textoDelReporte);
	}

	@Test
	void conMarcaDeExceso() {
		var g1 = gastoDesayuno(1001); // <- Solo cambio el monto para que marque que está en exceso
		var reporte = new ReporteDeGastos(List.of(g1));
		String textoDelReporte = capturarTextoDeSysOut(() -> {
					reporte.imprimir();
				}
		).stripTrailing();

		String[] lineas = {
				"'Expenses' uuuu-MM-dd", // Para DateTimeFormatter
				"Desayuno\t1001\tX",    // <- Solo cambia el monto y la marca
				"Gastos de comida: 1001",
				"Total de gastos: 1001",
		};
		// La primera linea contiene la fecha de hoy.
		lineas[0] = LocalDate.now().format(DateTimeFormatter.ofPattern(lineas[0]));
		// Unir el texto
		String esperado = String.join("\n", lineas);

		assertEquals(esperado, textoDelReporte);
	}

	@Test
	void mixto() {
		Gasto[] gastos = {
				gastoDesayuno(1002),
				gastoCena(5001),
				gastoAlquilerAuto(34800),
		};
		var reporte = new ReporteDeGastos(List.of(gastos));
		String textoDelReporte = capturarTextoDeSysOut(() -> {
					reporte.imprimir();
				}
		).stripTrailing();

		String[] lineas = {
				"'Expenses' uuuu-MM-dd", // Para DateTimeFormatter
				"Desayuno\t1002\tX",
				"Cena\t5001\tX",
				"Alquiler de Autos\t34800\t ",
				"Gastos de comida: 6003",
				"Total de gastos: 40803",
		};
		// La primera linea contiene la fecha de hoy.
		lineas[0] = LocalDate.now().format(DateTimeFormatter.ofPattern(lineas[0]));
		// Unir el texto
		String esperado = String.join("\n", lineas);

		assertEquals(esperado, textoDelReporte);
	}

	@Test
	void vacio() {
		// Lista de gastos vacía.
		var reporte = new ReporteDeGastos(List.of());
		String textoDelReporte = capturarTextoDeSysOut(() -> {
					reporte.imprimir();
				}
		).stripTrailing();

		String[] lineas = {
				"'Expenses' uuuu-MM-dd", // Para DateTimeFormatter
				"Gastos de comida: 0",
				"Total de gastos: 0",
		};
		// La primera linea contiene la fecha de hoy.
		lineas[0] = LocalDate.now().format(DateTimeFormatter.ofPattern(lineas[0]));
		// Unir el texto
		String esperado = String.join("\n", lineas);

		assertEquals(esperado, textoDelReporte);
	}
}
