package io.bootcamp.codeforall.kernelfc;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {
    private Brush brush;
    private Keyboard keyboard;

    private Grid grid;


    public Game() {
        this.grid = new Grid();
        this.keyboard = new Keyboard(this);
        this.brush = new Brush(this.grid, new GridPosition(this.grid, 0, 0), grid.getCellSize());
    }


    public void initGame() {
        this.grid = new Grid();
        brush.initBrush();

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
