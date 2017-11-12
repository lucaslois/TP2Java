package modelo.casilleros;

import java.util.HashMap;

public class Tablero {
    private int LAST_ID = 19; // TODO: 19 HARDCODEADO, REPRESENTA LA CANTIDAD DE CASILLEROS DEL TABLERO

    private static Tablero instance;
    private HashMap<Integer, Casillero> tablero;

    public static Tablero getInstance() {
        if(instance == null)
            instance = new Tablero();
        return instance;
    }

    private Tablero() {
        this.tablero = new HashMap<Integer, Casillero>();
    }

    public void crearCasillero(Casillero casillero) {
        LAST_ID++;
        int id = LAST_ID;
        this.tablero.put(id, casillero);
    }

    public int getCantidadDeCasilleros() {
        return LAST_ID + 1;
    }

    public int getPosicionCarcel() {
        return 0;
    }
}
