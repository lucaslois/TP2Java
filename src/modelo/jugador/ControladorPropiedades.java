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

    public ControladorPropiedades() {

        this.terrenos = new ArrayList<Edificable>();
        this.servicios = new ArrayList<NoEdificable>();
    }

    public void comprar(Edificable unaPropiedad) {
        terrenos.add(unaPropiedad);
    }

    public void comprar(NoEdificable unServicio){ servicios.add(unServicio);}

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
}
