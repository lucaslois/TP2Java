package modelo.tablero.tipos_casilleros;


import modelo.jugador.Jugador;
import modelo.tablero.Casillero;
import modelo.tablero.tipos_casilleros.NoEdificable;
import modelo.tablero.tipos_casilleros.EstadoDeEmparejamiento;

public class Servicio extends Casillero implements NoEdificable {

    private int precio;
    private int precioSolo;
    private int precioConPar;
    private Jugador propietario;
    private EstadoDeEmparejamiento estadoDeEmparejamiento;
    private Servicio par;


    public Servicio(int precio, int precioSolo, int precioConPar) {
        this.precio = precio;
        this.precioSolo = precioSolo;
        this.precioConPar = precioConPar;
        this.propietario = null;
        this.estadoDeEmparejamiento = new EstadoDeEmparejamiento(0);// le manda cero porque al principio no es de nadie
        this.par = null; // creo que ya no sirve para nada esta referencia.

    }

    public void setPropietario(Jugador unJugador) {
        this.propietario = unJugador;
        this.estadoDeEmparejamiento = new EstadoDeEmparejamiento(this.precioSolo);
    }

    public Servicio setPar(Servicio par) {

        this.par = par;
        this.estadoDeEmparejamiento = new EstadoDeEmparejamiento(this.precioConPar);

        return this;
    }
    public int getPrecio(){
        return this.precio;
    }

    @Override
    public void liquidarPropiedad() {
        return;
    }

    public int getPrecioCuandoSeVende(){
        return (int) (this.getPrecio() * 0.85);
    }
    @Override
    public Jugador getPropietario() {
        return this.propietario;
    }

    public void pisar(Jugador jugador) {
        if (jugador != this.getPropietario()) {
            estadoDeEmparejamiento.pisar(jugador);
        }
    }
}