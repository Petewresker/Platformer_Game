package main;

import java.awt.Graphics;

import Levels.LevelManager;
import entities.Player;

public class Game implements Runnable{

    @SuppressWarnings("unused")
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    private Thread gameThread;

    private Player player;

    private LevelManager levelManager;

    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 1.5f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int)(TILES_DEFAULT_SIZE*SCALE);
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
    

    public Game(){
        initClasses(); //intialize player enemy and so on.
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocusInWindow();       
        startGameLoop();

    }

    private void initClasses(){
        levelManager = new LevelManager(this);
        player = new Player(200, 200,(int)(64 * SCALE) ,(int)(40*SCALE));
        player.loadLvlData(levelManager.getCurrentLevel().GetLevelData());
    }


    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
        
    }

    public void update(){
        player.update();
        levelManager.update();
    }

    public void render(Graphics g){
        levelManager.draw(g);
        player.render(g);

    }

    @Override
    public void run(){

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET; // Time of Frequency
        long previousTime = System.nanoTime();
        double deltaU = 0;
        double deltaF = 0;

        while(true){
            long currentTime = System.nanoTime();

            deltaU += (currentTime  - previousTime) / timePerUpdate;
            deltaF += (currentTime  - previousTime) / timePerFrame;
            previousTime = currentTime;

            if(deltaU >= 1){
                update();
                deltaU--;
            } 

            if(deltaF >= 1){
                gamePanel.repaint();
                deltaF--;
            } 
        }

    }

    public Player getPlayer(){
        return player;
    }

    public void windowFocusLost(){
        player.resetDirBoolean();
    }
}
