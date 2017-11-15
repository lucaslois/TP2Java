package AlgoPoly;

import modelo.casilleros.Barrio;
import modelo.casilleros.Casillero;
import modelo.casilleros.Quini6;
import modelo.casilleros.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {
/* TODO: AVERIGUAR COMO HACER PRUEBAS UNITARIAS CON SINGLETON
    @Test
    public void testSingletonTableroTieneSiempreLaMismaInstancia() {
        Tablero tablero = Tablero.getInstance();
        Tablero tablero2 = Tablero.getInstance();

        Assert.assertEquals(tablero, tablero2);
        Tablero.destroyInstance();
    }

    @Test
    public void testCrearTableroNoTieneCasilleros() {
        Tablero tablero = Tablero.getInstance();
        Assert.assertEquals(tablero.getCantidadDeCasilleros(), 0);
        Tablero.destroyInstance();
    }

    @Test
    public void testCrearTableroAgrego4ElementosYTiene4Elementos() {
        Tablero tablero = Tablero.getInstance();
        tablero.crearCasillero(new Barrio(4500));
        tablero.crearCasillero(new Barrio(3500));
        tablero.crearCasillero(new Quini6());
        tablero.crearCasillero(new Barrio(2000));
        Assert.assertEquals(tablero.getCantidadDeCasilleros(), 4);

        Tablero.destroyInstance();
    }

    @Test
    public void testCrearTableroCon4CasillerosElTerceroEsQuini6() {
        Tablero tablero = Tablero.getInstance();
        tablero.crearCasillero(new Barrio(4500));
        tablero.crearCasillero(new Barrio(3500));
        Casillero quini6 = tablero.crearCasillero(new Quini6());
        tablero.crearCasillero(new Barrio(2000));

        Assert.assertEquals(tablero.getCasillero(2), quini6);
        Tablero.destroyInstance();
    }
    */
}
