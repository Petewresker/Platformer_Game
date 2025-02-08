package Levels;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.Game;
import utilz.LoadSave;

public class LevelManager{

    @SuppressWarnings("unused")
    private Game game;
    private BufferedImage[] levelSprite;
    private Level levelone;

    public LevelManager(Game game){
        this.game = game;
        importOutsideSprite();
        levelone = new Level(LoadSave.GetLevelData());
    }

    public void draw(Graphics g){
        for(int row = 0 ; row < Game.TILES_IN_HEIGHT ; row++)
            for(int col = 0 ; col < Game.TILES_IN_WIDTH ; col++){
                int index  = levelone.getSpriteIndex(col , row);
                g.drawImage(levelSprite[index], Game.TILES_SIZE*col,Game.TILES_SIZE*row,Game.TILES_SIZE,Game.TILES_SIZE, null);
            }
        
    }

    public void update(){
        
    }

    public Level getCurrentLevel(){
        return levelone;
    }

    private void importOutsideSprite(){

        BufferedImage img = LoadSave.GetSpriteAtLas(LoadSave.LEVEL_ATLAS);
        levelSprite  = new BufferedImage[48];
        for(int row = 0 ; row < 4 ; row++){
            for(int col = 0 ; col < 12 ; col++){
                int index = row*12 + col;
                levelSprite[index] = img.getSubimage(col * 32, row * 32, 32, 32);
            }
        }
    }
}