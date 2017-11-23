package unitarias;

import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;

import modelo.tablero.tipos_casilleros.ImpuestoAlLujo;
import org.junit.Assert;
import org.junit.Test;

public class ImpuestoAlLujoTest {

    private static final double DELTA = 1e-15;

    @Test
    public void testJugadroCaeEnImpuestoAlLujoYSuDineroDecrementaEnUn10Porciento(){
        Tablero tablero = TableroFactory.crearTablero();
        Jugador jugador = new Jugador("Oli",tablero);
        ImpuestoAlLujo impuesto = new ImpuestoAlLujo();

        double Dinero = jugador.getDinero();
        impuesto.pisar(jugador);

        Assert.assertEquals(jugador.getDinero(), Dinero*0.9,DELTA);
    }
}
