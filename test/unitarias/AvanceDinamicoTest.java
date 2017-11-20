package unitarias;

import modelo.tablero.tipos_casilleros.AvanceDinamico;
import modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class AvanceDinamicoTest {
    @Test
    public void testJugadorCaeEnAvanceDinamicoSumando2345o6SuPosicionNuevaEs2MenosQueElNumeroSacado() {
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        Jugador unJugador = new Jugador("Kev");
        unJugador.setNumeroObtenido(3);
        avanceDinamico.pisar(unJugador);
        Assert.assertEquals(unJugador.getPosicion(), 1);
    }

    @Test
    public void testJugadorCaeEnAvanceDinamicoSumando789o10SuPosicionNuevaDependeDeSuDinero() {
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        Jugador unJugador = new Jugador("Kev");
        unJugador.setNumeroObtenido(7);
        avanceDinamico.pisar(unJugador);
        Assert.assertEquals(unJugador.getPosicion(), 5);
    }
    @Test
    public void testJugadorCaeEnAvanceDinamicoSumando11o12AvanzaTotalPorqueNoTienePropiedades() {
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        Jugador unJugador = new Jugador("Kev");
        unJugador.setNumeroObtenido(12);
        avanceDinamico.pisar(unJugador);
        Assert.assertEquals(unJugador.getPosicion(), 12);
    }

}
