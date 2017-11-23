package unitarias;

import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;

import modelo.tablero.tipos_casilleros.Servicio;
import org.junit.Assert;
import org.junit.Test;

public class ServiciosTest {

    @Test
    public void testJugadorTieneEdesurPeroNoAYSAOtroJugadorCaeYLeCobran500VecesLoQueDicenLosDados(){
        Tablero tablero = TableroFactory.crearTablero();
        Jugador unJugador = new Jugador("EvilOli", tablero);
        Servicio edesur = new Servicio(35000,500,1000);
        unJugador.comprar(edesur);

        Jugador otroJugador = new Jugador("Oli",tablero);
        int Dinero = (int)otroJugador.getDinero();
        otroJugador.setUltimaTiradaDados(5);
        edesur.pisar(otroJugador);

        Assert.assertEquals((int)otroJugador.getDinero(), Dinero-(5*500));
    }

    @Test
    public void testJugadorCompraEdesurYAYSAOtroJugadroCaeEnEdesurYTieneQuePagar1000VecesLoQueSacoEnLosDados(){
        Tablero tablero = TableroFactory.crearTablero();
        Jugador unJugador = new Jugador("EvilOli", tablero);
        Servicio edesur = new Servicio(35000,500,1000);
        Servicio aysa = new Servicio(30000,300,500);
        edesur.setPar(aysa);
        aysa.setPar(edesur);
        unJugador.comprar(edesur);
        unJugador.comprar(aysa);

        Jugador otroJugador = new Jugador("Oli",tablero);
        int Dinero = (int)otroJugador.getDinero();
        otroJugador.setUltimaTiradaDados(5);
        edesur.pisar(otroJugador);

        Assert.assertEquals((int)otroJugador.getDinero(), Dinero-(5*1000));
    }


}
