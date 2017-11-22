package modelo.tablero;

import modelo.tablero.tipos_casilleros.*;

public class TableroFactory {
    public static Tablero crearTablero() {
        Tablero tablero = new Tablero();
        tablero.agregarCasillero(new Salida());
        tablero.agregarCasillero(new Barrio(4500));
        tablero.agregarCasillero(new Barrio(3500));
        tablero.agregarCasillero(new Quini6());
        tablero.agregarCasillero(new Carcel());
        tablero.agregarCasillero(new Barrio(3000));
        tablero.agregarCasillero(new Barrio(6000));
        tablero.agregarCasillero(new Policia());
        tablero.agregarCasillero(new Barrio(2000));

        return tablero;
    }
}
