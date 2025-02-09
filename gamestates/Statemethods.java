package gamestates;

import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface Statemethods {
    // Colection of method that we want each class creat if they implement it.
    // It's the way to sure out that your project is already implemented methods

    // All state classes must have these.
    public void update();

    public void draw(Graphics g);

    public void mouseClick(MouseEvent e);

    public void mousePressed(MouseEvent e);

    public void mouseRelease(MouseEvent e);

    public void mouseMoved(MouseEvent e);

    public void keyPressed(KeyEvent e);

    public void keyReleased(KeyEvent e);


    /*So every class that implement need to have these method in it's own class
     * even if they are not the same methodology.
     */
}
