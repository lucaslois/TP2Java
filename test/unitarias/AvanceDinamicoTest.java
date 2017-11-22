package unitarias;

import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import modelo.tablero.tipos_casilleros.AvanceDinamico;
import modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class AvanceDinamicoTest {
    @Test
    public void testJugadorCaeEnAvanceDinamicoSumando2345o6SuPosicionNuevaEs2MenosQueElNumeroSacado() {
        Tablero tablero = TableroFactory.crearTablero();
        Jugador unJugador = new Jugador("Kev", tablero);
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        unJugador.setUltimaTiradaDados(5);
        avanceDinamico.pisar(unJugador);
        Assert.assertEquals(unJugador.getCantidadDePasosDados(), 3);
    }

    @Test
    public void testJugadorCaeEnAvanceDinamicoSumando789o10SuPosicionNuevaDependeDeSuDinero() {
        Tablero tablero = TableroFactory.crearTablero();
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        Jugador unJugador = new Jugador("Kev", tablero);
        unJugador.setUltimaTiradaDados(7);
        avanceDinamico.pisar(unJugador);
        Assert.assertEquals(unJugador.getCantidadDePasosDados(), 5);
    }
    @Test
    public void testJugadorCaeEnAvanceDinamicoSumando11o12AvanzaTotalPorqueNoTienePropiedades() {
        Tablero tablero = TableroFactory.crearTablero();
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        Jugador unJugador = new Jugador("Kev", tablero);
        unJugador.setUltimaTiradaDados(12);
        avanceDinamico.pisar(unJugador);
        Assert.assertEquals(unJugador.getCantidadDePasosDados(), 12);
    }

}
