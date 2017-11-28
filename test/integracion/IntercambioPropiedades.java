package integracion;


import modelo.tablero.Nodo;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import modelo.jugador.Jugador;
import modelo.tablero.tipos_casilleros.BarrioDoble;
import modelo.tablero.tipos_casilleros.BarrioSimple;
import org.junit.Assert;
import org.junit.Test;

public class IntercambioPropiedades {

    @Test
    public void testJugadorIntercambiaPropiedadConOtroJugadorYUnTercerJugadorCaeYElDineroLoCobraElNuevoDueño(){
        Tablero tablero=TableroFactory.crearTablero();
        Jugador unJugador = new Jugador("Oli", tablero);
        Jugador otroJugador = new Jugador("EvilOli",tablero);
        unJugador.avanzar(7);
        BarrioSimple santaFe= (BarrioSimple) (unJugador.getNodoActual()).getCasillero();

        santaFe.pisar(unJugador);
        unJugador.comprar(santaFe);
        otroJugador.avanzar(2);
        BarrioDoble baSur = (BarrioDoble)(otroJugador.getNodoActual().getCasillero());
        baSur.pisar(otroJugador);
        otroJugador.comprar(baSur);
        unJugador.intercambiarPropiedad(santaFe,baSur);

        Jugador tercerJugador = new Jugador("Juan",tablero);
        tercerJugador.avanzar(7);
        int Dinero = (int)otroJugador.getDinero();
        santaFe.pisar(tercerJugador);

        Assert.assertEquals((int)otroJugador.getDinero(),Dinero + 1500);
    }

    @Test
    public void testJugadorIntercambiaPropiedadConEdificacionesConOtroJugadorYLasCasasSonRemovidasUnTercerJugadorCaeYElDineroLoCobraElNuevoDueño() {
        Tablero tablero = TableroFactory.crearTablero();
        Jugador unJugador = new Jugador("Oli", tablero);
        Jugador otroJugador = new Jugador("EvilOli", tablero);
        unJugador.avanzar(7);
        BarrioSimple santaFe = (BarrioSimple) (unJugador.getNodoActual()).getCasillero();

        santaFe.pisar(unJugador);
        unJugador.comprar(santaFe);
        santaFe.agregarCasa(unJugador);//cambia esto a la anterior
        otroJugador.avanzar(2);
        BarrioDoble baSur = (BarrioDoble) (otroJugador.getNodoActual().getCasillero());
        baSur.pisar(otroJugador);
        otroJugador.comprar(baSur);
        unJugador.intercambiarPropiedad(santaFe, baSur);

        Jugador tercerJugador = new Jugador("Juan", tablero);
        tercerJugador.avanzar(7);
        int Dinero = (int) otroJugador.getDinero();
        santaFe.pisar(tercerJugador);

        Assert.assertEquals((int) otroJugador.getDinero(), Dinero + 1500);
    }




}
