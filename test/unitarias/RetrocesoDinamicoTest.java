package unitarias;

import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import modelo.tablero.tipos_casilleros.Barrio;
import modelo.jugador.Jugador;
import modelo.tablero.tipos_casilleros.BarrioSimple;
import modelo.tablero.tipos_casilleros.RetrocesoDinamico;
import org.junit.Assert;
import org.junit.Test;

public class RetrocesoDinamicoTest {
    @Test
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado4YRetrocede4UnidadesSinPropiedades() {
        Tablero tablero = TableroFactory.crearTablero();
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        Jugador unJugador = new Jugador("Oli", tablero);
        unJugador.setUltimaTiradaDados(4);
        casillero.pisar(unJugador);
        Assert.assertEquals(unJugador.getCantidadDePasosDados(), 4);
    }

    @Test
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado4YRetrocede1UnidadesCon2Casas() {
        Tablero tablero = TableroFactory.crearTablero();
        Barrio barrio = new BarrioSimple(4000,0,0,0,0);
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Magalí", tablero);
        jugador.comprar(barrio);
        barrio.agregarCasa();
        barrio.agregarCasa();

        jugador.setUltimaTiradaDados(4);
        casillero.pisar(jugador);
        Assert.assertEquals(jugador.getCantidadDePasosDados(), 1);
    }

    // SUPONGO QUE SI LA CANTIDAD DE PROPIEDADES ES MAYOR AL NUMERO SACADO, NO RETROCEDO CASILLEROS.
    @Test
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado4YRetrocede0UnidadesCon5Propiedades() {
        Tablero tablero = TableroFactory.crearTablero();
        Barrio barrio = new BarrioSimple(4000,0,0,0,0);
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Magalí", tablero);
        jugador.comprar(barrio);
        barrio.agregarCasa();
        barrio.agregarCasa();
        barrio.agregarCasa();
        barrio.agregarCasa();
        barrio.agregarCasa();

        jugador.setUltimaTiradaDados(4);
        casillero.pisar(jugador);
        Assert.assertEquals(jugador.getCantidadDePasosDados(), 0);
    }

    @Test
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado9Con75000PesosYRetrocede3Casillas() {
        Tablero tablero = TableroFactory.crearTablero();
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Magalí", tablero);

        jugador.pagar(25000);
        jugador.setUltimaTiradaDados(9);
        casillero.pisar(jugador);
        Assert.assertEquals(jugador.getCantidadDePasosDados(), 3);
    }

    @Test
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado12YRetrocede10Casillas() {
        Tablero tablero = TableroFactory.crearTablero();
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Magalí", tablero);

        jugador.setUltimaTiradaDados(12);
        casillero.pisar(jugador);
        Assert.assertEquals(jugador.getCantidadDePasosDados(), 10);
    }

}
