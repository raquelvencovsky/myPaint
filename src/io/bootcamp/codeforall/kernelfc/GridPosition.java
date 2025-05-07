package io.bootcamp.codeforall.kernelfc;


public class GridPosition {
    private Grid grid;
    private int col;
    private int row;
    private int x;
    private int y;
    public GridPosition(Grid grid, int col, int row) {
        this.grid = grid;
        this.col = col;
        this.row = row;
        this.x = colToX();
        this.y = rowToY();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int colToX() {
        return (col * grid.getCellSize()) + grid.getPADDING();
    }
    public int rowToY() {
        return (row * grid.getCellSize())+ grid.getPADDING();
    }
}
