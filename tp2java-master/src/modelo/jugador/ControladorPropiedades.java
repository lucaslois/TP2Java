package modelo.jugador;

import modelo.casilleros.Comprable;
import modelo.casilleros.Edificable;

import java.util.ArrayList;

public class ControladorPropiedades {
    private ArrayList<Edificable> terrenos;
   // private ArrayList<Servicios> servicios;

    public ControladorPropiedades() {
        this.terrenos = new ArrayList<Edificable>();
    }

    public void comprar(Edificable unaPropiedad) {
        terrenos.add(unaPropiedad);
    }

    public ArrayList<Edificable> getPropiedades() {
        return this.terrenos;
    }

    public int getCantidadTotalPropiedades() {
        int total = 0;
        for(Edificable prop : this.terrenos) {
            total++;
            total = prop.getCasass() + prop.getHoteles();
        }
        return total;
    }

    public boolean tienePropiedad(Comprable barrio) {
        return this.terrenos.contains(barrio);
    }
}
