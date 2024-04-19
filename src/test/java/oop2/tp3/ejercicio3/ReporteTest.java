package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
		var g1 = new Gasto();
		g1.tipoGasto = TipoDeGasto.DESAYUNO;
		g1.monto = 1000;
		var reporte = new ReporteDeGastos();
		String textoDelReporte = capturarTextoDeSysOut(() -> {
					reporte.imprimir(List.of(g1));
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
		var g1 = new Gasto();
		g1.tipoGasto = TipoDeGasto.DESAYUNO;
		g1.monto = 1001;    // <- Solo cambio el monto para que marque que está en exceso
		var reporte = new ReporteDeGastos();
		String textoDelReporte = capturarTextoDeSysOut(() -> {
					reporte.imprimir(List.of(g1));
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
}
