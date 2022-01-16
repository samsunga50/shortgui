// AWT stands for “Abstract Window Toolkit”
/*
A Canvas is a blank rectangular area of the screen onto which the application can draw.
The Graphics class provides basic drawing methods such as drawLine, drawRect, and drawString
 */
import java.util.Random;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.Scanner;


public class draw extends Canvas{
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new draw();
        canvas.setSize(800, 800);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);

    }



    public void paint(Graphics g) {
        int n = 25;
        node[] nodes = new node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new node();
        }
        for (int i = 0; i < n; i++) {
            g.drawString("X", nodes[i].x, nodes[i].y);

            for (int j = 0; j < n; j++){
                g.drawLine(nodes[i].x, nodes[i].y, nodes[j].x, nodes[j].y);
            }

        }
    }

}
