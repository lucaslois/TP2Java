package unitarias;


import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;

import modelo.tablero.tipos_casilleros.Transporte;
import org.junit.Assert;
import org.junit.Test;

public class TransporteTest {



    @Test
    public void testJugadorCompraTrenesSinTenerSubteOtroJugadroCaeYTieneQuePagar450VecesLoQueSacoEnLosDados(){
        Tablero tablero = TableroFactory.crearTablero();
        Jugador unJugador = new Jugador("EvilOli", tablero);
        Transporte trenes = new Transporte(38000,450,800);
        unJugador.comprar(trenes);

        Jugador otroJugador = new Jugador("Oli",tablero);
        int Dinero = otroJugador.getDinero();
        otroJugador.setUltimaTiradaDados(5);
        trenes.pisar(otroJugador);

        Assert.assertEquals(otroJugador.getDinero(), Dinero-(5*450));
    }

    @Test
    public void testJugadorCompraSubteYTrenesOtroJugadroCaeEnTrenesYTieneQuePagar800VecesLoQueSacoEnLosDados(){
        Tablero tablero = TableroFactory.crearTablero();
        Jugador unJugador = new Jugador("EvilOli", tablero);
        Transporte trenes = new Transporte(38000,450,800);
        Transporte subte = new Transporte(40000,600,1100);
        trenes.setPar(subte);
        subte.setPar(trenes);
        unJugador.comprar(trenes);
        unJugador.comprar(subte);

        Jugador otroJugador = new Jugador("Oli",tablero);
        int Dinero = otroJugador.getDinero();
        otroJugador.setUltimaTiradaDados(5);
        trenes.pisar(otroJugador);

        Assert.assertEquals(otroJugador.getDinero(), Dinero-(5*800));
    }

    


}
