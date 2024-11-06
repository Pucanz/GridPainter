package PaintGame;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {

    public static void main(String[] args) {



        Grid grid = new Grid(40, 20, 20);
        Player p1 = new Player(grid);


        new MyKeyboardHandler(p1);




    }

}
