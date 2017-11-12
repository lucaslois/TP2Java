package AlgoPoly;

import models.Desplazamiento;
import models.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class DesplazamientoTest {
    @Test
    public void testJugadorCaeEnAvanceDinamicoSumando2345o6SuPosicionNuevaEs2MenosQueElNumeroSacado() {
        Desplazamiento avanceDinamico = new Desplazamiento("H");
        Jugador unJugador = new Jugador("Kev");
        unJugador.setNumeroObtenido(3);
        avanceDinamico.pisar(unJugador);
        Assert.assertEquals(unJugador.getPosicion(), 1);
    }

    @Test
    public void testJugadorCaeEnAvanceDinamicoSumando789o10SuPosicionNuevaDependeDeSuDinero() {
        Desplazamiento avanceDinamico = new Desplazamiento("H");
        Jugador unJugador = new Jugador("Kev");
        unJugador.setNumeroObtenido(7);
        avanceDinamico.pisar(unJugador);
        Assert.assertEquals(unJugador.getPosicion(), 6);
    }
    @Test
    public void testJugadorCaeEnAvanceDinamicoSumando11o12SuPosicionNuevaDependeDeSuDinero() {
        Desplazamiento avanceDinamico = new Desplazamiento("H");
        Jugador unJugador = new Jugador("Kev");
        unJugador.setNumeroObtenido(12);
        avanceDinamico.pisar(unJugador);
        Assert.assertEquals(unJugador.getPosicion(), 12);
    }

}
