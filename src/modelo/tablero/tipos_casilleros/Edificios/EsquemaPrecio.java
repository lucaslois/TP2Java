package modelo.tablero.tipos_casilleros.Edificios;

public class EsquemaPrecio {
    private int precioAlquilerCeroCasas;
    private int precioAlquilerUnaCasa;
    private int precioAlquilerDosCasas;
    private int precioAlquilerHotel;

    private int precioConstruirCasa;
    private int precioConstruirHotel;

    public EsquemaPrecio() {
        this.precioAlquilerCeroCasas = 0;
        this.precioAlquilerUnaCasa = 0;
        this.precioAlquilerDosCasas = 0;
        this.precioAlquilerHotel = 0;
        this.precioConstruirCasa = 0;
        this.precioConstruirHotel = 0;
    }
    public int getPrecioAlquilerCeroCasas(){return this.precioAlquilerCeroCasas;}
    public int getPrecioAlquilerUnaCasa() { return this.precioAlquilerUnaCasa; }
    public int getPrecioAlquilerDosCasas() {return this.precioAlquilerDosCasas;}
    public int getPrecioAlquilerHotel() { return this.precioAlquilerHotel; }
    public int getPrecioConstruirCasa() { return this.precioConstruirCasa;}
    public int getPrecioConstruirHotel() { return this.precioConstruirHotel; }

    public EsquemaPrecio setPrecioAlquilerCeroCasas(int valor){
        this.precioAlquilerCeroCasas = valor;
        return this;
    }
    public EsquemaPrecio setPrecioAlquilerUnaCasa(int valor) {
        this.precioAlquilerUnaCasa = valor;
        return this;
    }

    public EsquemaPrecio setPrecioAlquilerDosCasas(int valor) {
        this.precioAlquilerDosCasas = valor;
        return this;
    }

    public EsquemaPrecio setPrecioAlquilerHotel(int valor) {
        this.precioAlquilerHotel = valor;
        return this;
    }

    public EsquemaPrecio setPrecioConstruirCasa(int valor) {
        this.precioConstruirCasa = valor;
        return this;
    }

    public EsquemaPrecio setPrecioConstruirHotel(int valor) {
        this.precioConstruirHotel = valor;
        return this;
    }

}
