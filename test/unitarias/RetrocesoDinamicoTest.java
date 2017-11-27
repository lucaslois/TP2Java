package unitarias;

import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import modelo.tablero.tipos_casilleros.Barrio;
import modelo.jugador.Jugador;
import modelo.tablero.tipos_casilleros.BarrioSimple;
import modelo.tablero.tipos_casilleros.Edificios.EsquemaPrecio;
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
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado4YRetrocede1UnidadesCon3Propiedades() {
        Tablero tablero = TableroFactory.crearTablero();
        EsquemaPrecio esquema = new EsquemaPrecio();
        esquema.setPrecioAlquilerUnaCasa(0)
                .setPrecioAlquilerDosCasas(0)
                .setPrecioAlquilerHotel(0)
                .setPrecioConstruirCasa(0)
                .setPrecioConstruirHotel(0);
        Barrio barrio = new BarrioSimple(4000,esquema);
        Barrio barrio2 = new BarrioSimple(4000,esquema);

        RetrocesoDinamico casillero = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Magalí", tablero);
        jugador.comprar(barrio);
        jugador.comprar(barrio2);
        //barrio.agregarCasa(jugador);
        barrio2.agregarCasa(jugador);

        jugador.setUltimaTiradaDados(4);
        casillero.pisar(jugador);
        Assert.assertEquals(jugador.getCantidadDePasosDados(), 1);
    }

    // SUPONGO QUE SI LA CANTIDAD DE PROPIEDADES ES MAYOR AL NUMERO SACADO, NO RETROCEDO CASILLEROS.
    @Test
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado4YRetrocede0UnidadesCon5Propiedades() {
        Tablero tablero = TableroFactory.crearTablero();
        EsquemaPrecio esquema = new EsquemaPrecio();
        esquema.setPrecioAlquilerUnaCasa(0)
                .setPrecioAlquilerDosCasas(0)
                .setPrecioAlquilerHotel(0)
                .setPrecioConstruirCasa(0)
                .setPrecioConstruirHotel(0)
                .setPrecioAlquilerCeroCasas(0);
        Barrio barrio = new BarrioSimple(4000,esquema);
        Barrio barrio2 = new BarrioSimple(4000,esquema);
        Barrio barrio3 = new BarrioSimple(4000,esquema);
        Barrio barrio4 = new BarrioSimple(4000,esquema);
        Barrio barrio5 = new BarrioSimple(4000,esquema);

        RetrocesoDinamico casillero = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Magalí", tablero);
        jugador.comprar(barrio);
        jugador.comprar(barrio2);
        jugador.comprar(barrio3);
        jugador.comprar(barrio4);
        jugador.comprar(barrio5);
        barrio.agregarCasa(jugador);
        barrio2.agregarCasa(jugador);
        barrio3.agregarCasa(jugador);
        barrio4.agregarCasa(jugador);
        barrio5.agregarCasa(jugador);

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
