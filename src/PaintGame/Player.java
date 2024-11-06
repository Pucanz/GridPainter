package PaintGame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Player {

    private Rectangle player;
    private Grid grid;

    private Keyboard keyboard;
    //private boolean paintedCell;

    private static int MOVE_DISTANCE = 0;

    public Player(Grid grid) {
        this.grid = grid;
        MOVE_DISTANCE = grid.getCellSize();
        player = new Rectangle(10, 10, grid.getCellSize(), grid.getCellSize());
        player.setColor(Color.BLUE);
        player.fill();

    }

    public void moveLeft() {
        if (player.getX() - MOVE_DISTANCE >= grid.getLeft_Bound()) {
            player.translate(-MOVE_DISTANCE, 0);
        }
    }

    public void moveRight() {
        if (player.getX() + MOVE_DISTANCE <= grid.getRightBound()) {
            player.translate(MOVE_DISTANCE, 0);
        }
    }

    public void moveUP() {
        if (player.getY() - MOVE_DISTANCE >= grid.getUpBound()) {
            player.translate(0, -MOVE_DISTANCE);

        }
    }

    public void moveDown() {
        if (player.getY() + MOVE_DISTANCE <= grid.getDownBound()) {
            player.translate(0, MOVE_DISTANCE);

        }
    }

    LinkedList<Rectangle> rectangleList = new LinkedList<>();

    public void paintCell() {
        Rectangle currentCell = new Rectangle(player.getX(), player.getY(), grid.getCellSize(), grid.getCellSize());
        rectangleList.add(currentCell);
        currentCell.setColor(Color.BLACK);
        currentCell.fill();
    }

    public void getPaintedCell() {

        boolean rectangleExists = false;

        for (int i = 0; i < rectangleList.size(); i++) {
            Rectangle tempRect = rectangleList.get(i);
            if (tempRect.getX() == player.getX() && tempRect.getY() == player.getY()) {
                tempRect.delete();
                rectangleList.remove(tempRect);
                rectangleExists = true;
            }
        }
        if (rectangleExists == false) {
            paintCell();
        }
    }

    public void clearAllCell() {
        for (int i = 0; i < rectangleList.size(); i++) {
            Rectangle temRect = rectangleList.get(i);
            temRect.delete();
            while (rectangleList.isEmpty()) {
                rectangleList.remove(temRect);
            }
        }

    }

    public void save() {
        try {
            FileWriter save = new FileWriter("Resources/save.txt");
            BufferedWriter buffer = new BufferedWriter(save);

            for (int i = 0; i < rectangleList.size(); i++) {
                Rectangle tempRect = rectangleList.get(i);
                buffer.write(tempRect.getX() + " " + tempRect.getY() + "\n");
            }

            buffer.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load() {
        clearAllCell();
        try {
            FileReader load = new FileReader("Resources/save.txt");
            BufferedReader buffer = new BufferedReader(load);
            String line;
            while((line = buffer.readLine()) != null) {
            String [] rectangles = line.split(" ");

                // fill those rectangles, add to the linkedlist
                int x = Integer.parseInt(rectangles[0]);
                int y = Integer.parseInt(rectangles[1]);
                Rectangle rect = new Rectangle(x, y, grid.getCellSize(), grid.getCellSize());
                rect.fill();
                rectangleList.add(rect);

                }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}