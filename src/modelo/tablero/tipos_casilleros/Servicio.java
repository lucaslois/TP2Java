package modelo.tablero.tipos_casilleros;

import modelo.jugador.Jugador;
import modelo.tablero.Casillero;

import java.util.ArrayList;

public class Servicio extends Casillero implements NoEdificable {

    private int precio;
    private Jugador propietario;
    //private EstadoTransporte objEstadoTransporte; TODO: POSIBLE REFACTORIZACION AGREGAR EL PATRON STATE EN VEZ DEL ARRAY, PERO PARA CADA TRANSPORTE SON DISTINTOS LOS VALORES
    private ArrayList<Integer> valores;
    private Servicio par;


    public Servicio(int precio, int valor1, int valor2){
        this.precio = precio;
        this.propietario = null;
        //this.objEstadoTransporte = new EstadoSolo(valor1);
        this.valores = new ArrayList<Integer>();
        this.valores.add(valor1);
        this.valores.add(valor2);
        this.par = null;

    }


    @Override
    public void setPropietario(Jugador unJugador) {
        this.propietario = unJugador;

    }

    public Servicio setPar(Servicio par){
        this.par = par;
        return this;
    }

    @Override
    public Jugador getPropietario() {
        return this.propietario;
    }

    @Override
    public int getPrecio() {
        return this.precio;
    }

    @Override
    public void pisar(Jugador jugador) {
        if((jugador != this.getPropietario()) && (this.getPropietario() != null)) {
            int dados = jugador.getNumeroObtenedido();
            //this.objEstadoTransporte.cobrar(Jugador);
            if (this.propietario.esDuenioDePropiedad(this.par)) {//si tiene los dos transportes
                jugador.pagar(this.valores.get(1) * dados);
                return;
            }
            jugador.pagar(this.valores.get(0) * dados);//solo un transporte
        }
    }
}
