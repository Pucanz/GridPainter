package PaintGame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {


    private int cols;
    private int rows;
    private int cellSize;
    private int offSetX;
    private int offSetY;
    private static int LEFT_BOUND;
    private static int RIGHT_BOUND;

    private static int UP_BOUND;

    private static int DOWN_BOUND;


    public Grid(int cols, int rows, int cellSize) {
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
        this.offSetX = 10;
        this.offSetY = 10;
        LEFT_BOUND = 0;
        RIGHT_BOUND = cols * cellSize;
        UP_BOUND = 0;
        DOWN_BOUND = rows * cellSize;
        drawGrid();
    }

    public void drawGrid() {
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {

                int x = offSetX + col * cellSize;
                int y = offSetY + row * cellSize;

                Rectangle grid = new Rectangle(x, y, cellSize, cellSize);
                grid.draw();

            }
        }
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getLeft_Bound() {
        return LEFT_BOUND;
    }

    public int getRightBound() {
        return RIGHT_BOUND;
    }

    public int getUpBound() {
        return UP_BOUND;
    }

    public int getDownBound() {
        return DOWN_BOUND;
    }

}
