package modelo.tablero;

import modelo.tablero.tipos_casilleros.Carcel;

// SINGLETON
public class Tablero {
    private Nodo nodoInicial;
    private Nodo nodoCarcel = null;
    private Nodo posicionSalida = null;
    private int cantidad_nodos;

    public Tablero() {
        this.cantidad_nodos = 0;
    }

    public void agregarNodo(Nodo nodo) {
        if(nodoInicial == null) {
            nodoInicial = nodo;
            nodo.setNodoAnterior(nodo);
            this.posicionSalida = nodo;
            this.cantidad_nodos++;
            return;
        }
        Nodo nodoUltimo = nodoInicial.getNodoAnterior();
        nodoUltimo.setNodoSiguiente(nodo);
        nodo.setNodoAnterior(nodoUltimo);
        nodo.setNodoSiguiente(nodoInicial);
        nodoInicial.setNodoAnterior(nodo);

        this.cantidad_nodos++;
    }

    public void agregarCasillero(Casillero casillero) {
        // TODO: BUSCAR FORMA CORRECTA
        Nodo nodo = new Nodo(casillero);
        if(casillero instanceof Carcel)
            this.nodoCarcel = nodo;
        this.agregarNodo(nodo);
    }

    public Nodo getNodoSalida() {
        return this.nodoInicial;
    }

    public Nodo getNodoCarcel() {return this.nodoCarcel;}

    /*
    public void enviarALaCarcel(Jugador unJugador) {
        Posicion pos = this.nodoCarcel;
        unJugador.setNodoActual(pos);
        unJugador.encarcelar();
    }

    public int getCantidadDeCasilleros() {
        return tablero.size();
    }

    public Posicion getPosicionCarcel() {
        return this.nodoCarcel;
    }

    public void colocarJugador(Jugador unJugador) {
        unJugador.setNodoActual(this.posicionSalida);
    }
    */

}
