package modelo.casilleros;

import java.util.HashMap;

// SINGLETON
public class Tablero {
    private int LAST_ID = 19; // TODO: 19 HARDCODEADO, REPRESENTA LA CANTIDAD DE CASILLEROS DEL TABLERO

    private static Tablero instance;
    private HashMap<Integer, Casillero> tablero;
    private int posicionCarcel = -1;

    public static Tablero getInstance() {
        if(instance == null)
            instance = new Tablero();
        return instance;
    }

    private Tablero() {
        this.tablero = new HashMap<Integer, Casillero>();
    }

    public Casillero crearCasillero(Casillero casillero) {
        LAST_ID++;
        int id = LAST_ID;
        this.tablero.put(id, casillero);
        return casillero;
    }

    public Casillero crearCasillero(Carcel carcel) {
        Casillero retorno = crearCasillero((Casillero) carcel);
        this.posicionCarcel = LAST_ID;
        return retorno;
    }

    public int getCantidadDeCasilleros() {
        return LAST_ID + 1;
    }

    public int getPosicionCarcel() {
        return this.posicionCarcel;
    }
}
