package oop2.tp3.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Random;

import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class ConsultaTest {

    private PersonaRepository repo;

    @BeforeAll
    void setup() {
        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");

        new SetUpDatabase(jdbi).setUp();

        this.repo = new PersonaRepository(jdbi);
    }

    void assertarTamanoLista(List<?> lista, int size) {
        assertNotNull(lista);
        assertEquals(size, lista.size());
    }

    void assertarListaVacia(List<?> lista) {
        assertarTamanoLista(lista, 0);
    }

    @Test
    void consultaPersonasDelMain() {
        var personas = repo.buscarPorNombre("Vla");
        assertarTamanoLista(personas, 1);
        var persona = personas.get(0);
        assertEquals("Vladimir Varkov", String.join(" ", persona.nombre(), persona.apellido()));
    }

    @Test
    void consultaPorIdDelMain() {
        var persona = repo.buscarId(1L);
        assertNotNull(persona);
        assertEquals("José Laurenti", String.join(" ", persona.nombre(), persona.apellido()));
    }

    @Test
    void consultaPorNombre() {
        Persona JoseLaurenti = new Persona("José", "Laurenti");
        Persona EstebanOtermon = new Persona("Esteban", "Otermon");
        Persona VladimirVarkov = new Persona("Vladimir", "Varkov");

        var personas1 = repo.buscarPorNombre("vla");
        assertarListaVacia(personas1);

        var personas2 = repo.buscarPorNombre("Vla");
        assertarTamanoLista(personas2, 1);
        assertEquals(VladimirVarkov, personas2.get(0));

        var listaConE = repo.buscarPorNombre("e");
        assertarTamanoLista(listaConE, 1);
        assertEquals(EstebanOtermon, listaConE.get(0));

        var listaConEConTilde = repo.buscarPorNombre("é");
        assertarTamanoLista(listaConEConTilde, 1);
        assertEquals(JoseLaurenti, listaConEConTilde.get(0));

        var porNombreVacio = repo.buscarPorNombre("");
        assertarTamanoLista(porNombreVacio, 3);
    }

    @Test
    void consultaPorId() {
        for (long id : new Long[] { 1L, 2L, 3L }) {
            assertNotNull(repo.buscarId(id));
        }

        var idsNoExistentes = new Random().longs(4L, 999L).limit(10).iterator();
        for (long id : (Iterable<Long>) () -> idsNoExistentes) {
            assertNull(repo.buscarId(id));
        }
    }
}
