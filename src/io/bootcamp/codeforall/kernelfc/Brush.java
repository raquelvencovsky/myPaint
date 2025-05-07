package io.bootcamp.codeforall.kernelfc;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;



public class Brush implements KeyboardHandler {

    private Rectangle brushIcon;

    private Grid grid;

    private Rectangle curCell;


    private GridPosition gridPosition;
    private Keyboard keyboard;


    public Brush(Grid grid, GridPosition gridPosition, int CELL_SIZE) {
        this.gridPosition = gridPosition;
        this.brushIcon = new Rectangle(this.gridPosition.getX(), this.gridPosition.getY(), CELL_SIZE, CELL_SIZE);
        this.keyboard = new Keyboard(this);
        this.grid = grid;
        createKeyboardEvents();
    }

    public void initBrush() {
        this.brushIcon.setColor(Color.GREEN);
        this.brushIcon.fill();
    }

    public void paint() {

        this.curCell = grid.getCell(brushIcon.getX(), brushIcon.getY());
        this.curCell.setColor(Color.BLACK);
        this.curCell.fill();
        grid.setPainted(brushIcon.getX(), brushIcon.getY(), true);

    }


    public void erase() {
        this.curCell = grid.getCell(brushIcon.getX(), brushIcon.getY());
        this.curCell.setColor(Color.BLACK);
        this.curCell.draw();
        grid.setPainted(brushIcon.getX(), brushIcon.getY(), false);
    }

    private void saveDrawing() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("drawing.txt"))) {
            for (Map.Entry<String, Boolean> entry : grid.getPaintMap().entrySet()) {
                if (entry.getValue()) {
                    writer.write(entry.getKey());
                    writer.newLine();
                }
            }
            System.out.println("Drawing saved!");
        } catch (IOException e) {
            System.out.println("Error saving drawing: " + e.getMessage());
        }
    }

    private void loadDrawing() {
        try (BufferedReader reader = new BufferedReader(new FileReader("drawing.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] coords = line.split(",");
                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);

                Rectangle cell = grid.getCell(x, y);
                cell.setColor(Color.BLACK);
                cell.fill();
                grid.setPainted(x, y, true);
            }
            System.out.println("Drawing loaded!");
        } catch (IOException e) {
            System.out.println("Error loading drawing: " + e.getMessage());
        }
    }
    private void clearDrawing() {
        for (Map.Entry<String, Boolean> entry : grid.getPaintMap().entrySet()) {
            if (entry.getValue()) {
                String[] coords = entry.getKey().split(",");
                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);

                Rectangle cell = grid.getCell(x, y);
                cell.setColor(Color.BLACK);
                cell.draw();
                grid.setPainted(x, y, false);
            }
        }
        System.out.println("Grid cleared!");
    }



    public void createKeyboardEvents() {

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventUp);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDown);

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSpace);

        KeyboardEvent keyboardEventS = new KeyboardEvent();
        keyboardEventS.setKey(KeyboardEvent.KEY_S);
        keyboardEventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventS);

        KeyboardEvent keyboardEventL = new KeyboardEvent();
        keyboardEventL.setKey(KeyboardEvent.KEY_L);
        keyboardEventL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventL);

        KeyboardEvent keyboardEventC = new KeyboardEvent();
        keyboardEventC.setKey(KeyboardEvent.KEY_C);
        keyboardEventC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventC);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int distanceToMove;
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (gridPosition.getX() <= 10) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = -40;
                }
                this.brushIcon.translate(distanceToMove, 0);
                this.gridPosition.setX(this.brushIcon.getX());

                break;
            case KeyboardEvent.KEY_RIGHT:
                if (gridPosition.getX() >= 750) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = 40;
                }
                this.brushIcon.translate(distanceToMove, 0);
                this.gridPosition.setX(this.brushIcon.getX());

                break;
            case KeyboardEvent.KEY_UP:
                if (gridPosition.getY() == 10) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = -40;
                }
                this.brushIcon.translate(0, distanceToMove);
                this.gridPosition.setY(this.brushIcon.getY());

                break;
            case KeyboardEvent.KEY_DOWN:
                if (gridPosition.getY() >= 750) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = 40;
                }
                this.brushIcon.translate(0, distanceToMove);
                this.gridPosition.setY(this.brushIcon.getY());

                break;

            case KeyboardEvent.KEY_SPACE:
                if (grid.getPainted(brushIcon.getX(), brushIcon.getY())) {
                    erase();
                } else {
                    paint();
                }
                break;

            case KeyboardEvent.KEY_S:
                saveDrawing();
                break;

            case KeyboardEvent.KEY_L:
                loadDrawing();
                break;

            case KeyboardEvent.KEY_C:
                clearDrawing();
                break;
        }
    }
}



