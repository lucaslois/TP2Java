package modelo.jugador;

public class Dados {
    private static Dados ourInstance = new Dados();
    private int valor1;
    private int valor2;
    private int resultadoDado1;

    public static Dados getInstance() {
        return ourInstance;
    }

    private Dados() {
        tirarDados();//para que queden inicializados
    }

    public int tirarDados(){
        valor1 = (int) (Math.random() * 6) + 1;
        valor2 = (int) (Math.random() * 6) + 1;
        return valor1+valor2;
    }

    public int setTirada(int n1, int n2){
        valor1=n1;
        valor2=n2;
        return valor1+valor2;
    }

    public boolean esDoble(){
        return valor1==valor2;
    }

    public int getResultadoDado1() {
        return this.valor1;
    }

    public int getResultadoDado2() {
        return this.valor2;
    }
}
