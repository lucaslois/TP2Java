package unitarias;


import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;

import modelo.tablero.tipos_casilleros.Servicio;
import org.junit.Assert;
import org.junit.Test;

public class TransporteTest {



    @Test
    public void testJugadorCompraTrenesSinTenerSubteOtroJugadroCaeYTieneQuePagar450VecesLoQueSacoEnLosDados(){
        Tablero tablero = TableroFactory.crearTablero();
        Jugador unJugador = new Jugador("EvilOli", tablero);
        Servicio trenes = new Servicio("Barrio", 38000,450,800);
        unJugador.comprar(trenes);

        Jugador otroJugador = new Jugador("Oli",tablero);
        int Dinero = (int)otroJugador.getDinero();
        otroJugador.setUltimaTiradaDados(5);
        trenes.pisar(otroJugador);

        Assert.assertEquals((int)otroJugador.getDinero(), Dinero-(5*450));
    }

    @Test
    public void testJugadorCompraSubteYTrenesOtroJugadroCaeEnTrenesYTieneQuePagar800VecesLoQueSacoEnLosDados(){
        Tablero tablero = TableroFactory.crearTablero();
        Jugador unJugador = new Jugador("EvilOli", tablero);
        Servicio trenes = new Servicio("Barrio", 38000,450,800);
        Servicio subte = new Servicio("Barrio", 40000,600,1100);

        unJugador.comprar(trenes);
        unJugador.comprar(subte);
        trenes.setPar(subte);
        subte.setPar(trenes);
        Jugador otroJugador = new Jugador("Oli",tablero);
        int Dinero = (int)otroJugador.getDinero();
        otroJugador.setUltimaTiradaDados(5);
        trenes.pisar(otroJugador);

        Assert.assertEquals((int)otroJugador.getDinero(), Dinero-(5*800));
    }

    


}
