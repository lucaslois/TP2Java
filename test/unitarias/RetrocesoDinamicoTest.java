package unitarias;

import modelo.tablero.tipos_casilleros.Barrio;
import modelo.jugador.Jugador;
import modelo.tablero.tipos_casilleros.RetrocesoDinamico;
import org.junit.Assert;
import org.junit.Test;

public class RetrocesoDinamicoTest {
    @Test
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado4YRetrocede4UnidadesSinPropiedades() {
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Magalí");
        jugador.setPosicion(15);
        jugador.setNumeroObtenido(4);
        casillero.pisar(jugador);
        Assert.assertEquals(jugador.getPosicion(), 11);
    }

    @Test
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado4YRetrocede1UnidadesCon2Casas() {
        Barrio barrio = new Barrio(4000);
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Magalí");
        jugador.comprar(barrio);
        barrio.agregarCasa();
        barrio.agregarCasa();

        jugador.setPosicion(10);
        jugador.setNumeroObtenido(4);
        casillero.pisar(jugador);
        Assert.assertEquals(jugador.getPosicion(), 9);
    }

    // SUPONGO QUE SI LA CANTIDAD DE PROPIEDADES ES MAYOR AL NUMERO SACADO, NO RETROCEDO CASILLEROS.
    @Test
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado4YRetrocede0UnidadesCon5Propiedades() {
        Barrio barrio = new Barrio(4000);
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Magalí");
        jugador.comprar(barrio);
        barrio.agregarCasa();
        barrio.agregarCasa();
        barrio.agregarCasa();
        barrio.agregarCasa();
        barrio.agregarCasa();

        jugador.setPosicion(10);
        jugador.setNumeroObtenido(4);
        casillero.pisar(jugador);
        Assert.assertEquals(jugador.getPosicion(), 10);
    }

    @Test
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado9Con75000PesosYRetrocede3Casillas() {
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Magalí");
        jugador.setPosicion(12);
        jugador.pagar(25000);
        jugador.setNumeroObtenido(9);
        casillero.pisar(jugador);
        Assert.assertEquals(jugador.getPosicion(), 9);
    }

    @Test
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado12YRetrocede10Casillas() {
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Magalí");
        jugador.setPosicion(12);
        jugador.setNumeroObtenido(12);
        casillero.pisar(jugador);
        Assert.assertEquals(jugador.getPosicion(), 2);
    }

}
