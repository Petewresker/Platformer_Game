package main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;



public class GamePanel extends JPanel{

    private MouseInputs mouseInputs;
    private Game game;

    //120 / 40 animation


    public GamePanel(Game game){
        
        mouseInputs = new MouseInputs(this);
        this.game = game;
        //Fixed size using Panel instead Windows
        setPanelSize();
        setFocusable(true);
        requestFocusInWindow();
        
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        
    }



    private void setPanelSize(){
        //we do this cause window will include tab
        Dimension size = new Dimension(GAME_WIDTH,GAME_HEIGHT);
        /*Our pixel is 32 that mean it contain 1200/32 = 40 img wide */
        setPreferredSize(size);

    }



    public void updateGame(){

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //Always Null for this game last one
        //Buffered img can sepecific by sub image 
        //Coordinate and based size 64 * 40  then size

        game.render(g);
    }

    public Game getGame(){
        return game;
    }
}