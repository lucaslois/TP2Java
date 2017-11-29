package vista.Casilleros;

public class Posicionador {
    private int row;
    private int col;

    public Posicionador() {
        this.row = 0;
        this.col = 0;
    }

    public void next() {
        if(this.row == 0 && this.col < 5)
            this.col++;
        else if(this.col == 5 && this.row < 5)
            this.row++;
        else if(this.row == 5)
            this.col--;
        else if(this.col == 0)
            this.row--;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
}
