package vista.Casilleros;

public class Posicion {
    private int row;
    private int col;

    public Posicion() {
        this.row = 5;
        this.col = 5;
    }

    public void next() {
        if(this.row == 0 && this.col < 5)
            this.col++;
        else if(this.col == 5 && this.row < 5)
            this.row++;
        else if(this.row == 5 && this.col > 0)
            this.col--;
        else if(this.col == 0 && this.row > 0)
            this.row--;
    }

    public void next(int pasos) {
        for(int i = 0; i < pasos; i++) {
            this.next();
        }
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }

    public void setPos(int col, int row) {
        this.row = row;
        this.col = col;
    }
}
