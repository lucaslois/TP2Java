package modelo.tablero;

public class Nodo {
    Nodo nodoSiguiente;
    Nodo nodoAnterior;
    Casillero casillero;

    public Nodo(Casillero casillero, Nodo casilleroAnterior) {
        this.nodoAnterior = casilleroAnterior;
        this.casillero = casillero;
    }

    public Nodo(Casillero casillero) {
        this.casillero = casillero;
    }

    public void setNodoSiguiente(Nodo nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

    public void setNodoAnterior(Nodo nodoAnterior) {
        this.nodoAnterior = nodoAnterior;
    }

    public Nodo getNodoSiguiente() {
        return this.nodoSiguiente;
    }

    public Nodo getNodoAnterior() {
        return this.nodoAnterior;
    }

    public Casillero getCasillero() {
        return this.casillero;
    }
}
