package modelo.tablero;

import modelo.tablero.tipos_casilleros.Carcel;


public class Tablero {
    private Nodo nodoInicial;
    private Nodo nodoCarcel = null;


    public Tablero() {

    }

    public void agregarNodo(Nodo nodo) {
        if(nodoInicial == null) {
            nodoInicial = nodo;
            nodo.setNodoAnterior(nodo);
            return;
        }
        Nodo nodoUltimo = nodoInicial.getNodoAnterior();
        nodoUltimo.setNodoSiguiente(nodo);
        nodo.setNodoAnterior(nodoUltimo);
        nodo.setNodoSiguiente(nodoInicial);
        nodoInicial.setNodoAnterior(nodo);

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

}
