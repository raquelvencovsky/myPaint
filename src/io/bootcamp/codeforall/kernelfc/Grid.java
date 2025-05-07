package io.bootcamp.codeforall.kernelfc;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class Grid {

    private Rectangle cell;
    private Map<String, Rectangle> gridMap = new HashMap<>();
    private Map<String, Boolean> paintMap = new HashMap<>();

    private static final int CELL_SIZE = 40;
    private static final int COLS = 20;
    private static final int ROWS = 20;
    private static final int PADDING = 10;

    public Grid() {
        drawGrid();
    }

    public void drawGrid() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {

                cell = new Rectangle(getX(col), getY(row), CELL_SIZE, CELL_SIZE);

                cell.setColor(Color.BLACK);
                cell.draw();
                String key = getX(col) + "," + getY(row);
                gridMap.put(key, cell);
                paintMap.put(key, false);
            }
        }
    }


    public static int getCellSize() {
        return CELL_SIZE;
    }

    public static int getPADDING() {
        return PADDING;
    }

    public static int getX(int col) {
        return PADDING + col * CELL_SIZE;
    }

    public static int getY(int row) {
        return PADDING + row * CELL_SIZE;
    }

    public Rectangle getCell(int col, int row) {
        return gridMap.get(col + "," + row);
    }

    public Boolean getPainted(int col, int row) {
        return paintMap.get(col + "," + row);
    }

    public void setPainted(int col, int row, boolean value) {
        paintMap.put(col + "," + row, value);
    }

    public Map<String, Boolean> getPaintMap() {
        return paintMap;
    }



}