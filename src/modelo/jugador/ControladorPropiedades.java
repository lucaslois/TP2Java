package modelo.jugador;

import exceptions.JugadorNoEsDuenioDePropiedadException;
import modelo.tablero.tipos_casilleros.Comprable;
import modelo.tablero.tipos_casilleros.Edificable;
import modelo.tablero.tipos_casilleros.NoEdificable;
import modelo.tablero.tipos_casilleros.Servicio;

import java.util.ArrayList;

public class ControladorPropiedades {
    private ArrayList<Edificable> terrenos;
    private ArrayList<NoEdificable> servicios;
    private ArrayList<Comprable> comprables;
    private double precioTotalDePropiedades;

    public ControladorPropiedades() {

        this.terrenos = new ArrayList<Edificable>();
        this.servicios = new ArrayList<NoEdificable>();
    }

    public void comprar(Edificable unaPropiedad) {
        this.precioTotalDePropiedades+=unaPropiedad.getPrecio();
        terrenos.add(unaPropiedad);
    }

    public void comprar(NoEdificable unServicio){
        this.precioTotalDePropiedades+=unServicio.getPrecio();
        servicios.add(unServicio);}

    public ArrayList<Edificable> getPropiedades() {
        return this.terrenos;
    }

    public int getCantidadTotalPropiedades() {
        int total = 0;
        for(Edificable prop : this.terrenos) {
            total++;
            total += prop.getCantidadDeCasas() + prop.getCantidadDeHoteles();
        }
        total += this.servicios.size();
        return total;
    }

    public boolean tienePropiedad(Comprable propiedad) {

        return this.terrenos.contains(propiedad) || this.servicios.contains(propiedad);
    }



    public void borrar(Edificable terreno) {
        if(!this.tienePropiedad(terreno))
            throw new JugadorNoEsDuenioDePropiedadException();
        this.terrenos.remove(terreno);
    }

    public void borrar(NoEdificable terreno) {
        if(!this.tienePropiedad(terreno))
            throw new JugadorNoEsDuenioDePropiedadException();
        this.servicios.remove(terreno);
    }

    public ArrayList<Comprable> getComprables() {
        ArrayList<Comprable> nuevaLista = new ArrayList<>();
        nuevaLista.addAll(this.terrenos);
        nuevaLista.addAll(this.servicios);
        return nuevaLista;
    }

    public double getPrecioTotalDePropiedades() {
        return precioTotalDePropiedades*0.85; //porque solo recibe el 85 porciento de lo que vende
    }

    public ArrayList<NoEdificable> getServicios() {
        return this.servicios;
    }
}
