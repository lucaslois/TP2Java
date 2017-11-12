package modelo;

import modelo.casilleros.Tablero;

public class Posicion {
    public int posicionActual;

    public Posicion() {
        this.posicionActual = 0;
    }

    public void avanzar(int cantidad) {
        Tablero tablero = Tablero.getInstance();
        if(posicionActual + cantidad > tablero.getCantidadDeCasilleros())
            posicionActual = posicionActual + cantidad - tablero.getCantidadDeCasilleros() - 1;
        else
            posicionActual += cantidad;
    }

   public void retroceder(int cantidad) {
       Tablero tablero = Tablero.getInstance();
       if(posicionActual - cantidad < 0)
            posicionActual = posicionActual - cantidad + tablero.getCantidadDeCasilleros() + 1;
        else
            posicionActual -= cantidad;
    }

    public void setPosicion(int pos) {
        this.posicionActual = pos;
    }

    public int getPosicion() {
        return this.posicionActual;
    }
}
