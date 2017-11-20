package modelo.tablero;

import modelo.tablero.tipos_casilleros.*;

public class TableroFactory {
    public static Tablero crearTablero() {
        Tablero tablero = new Tablero();
        tablero.crearCasillero(new Salida());
        tablero.crearCasillero(new Barrio(4500));
        tablero.crearCasillero(new Barrio(3500));
        tablero.crearCasillero(new Quini6());
        tablero.crearCasillero(new Carcel());
        tablero.crearCasillero(new Barrio(3000));
        tablero.crearCasillero(new Barrio(6000));
        tablero.crearCasillero(new Policia());
        tablero.crearCasillero(new Barrio(2000));

        return tablero;
    }
}
