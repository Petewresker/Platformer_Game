package utilz;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.Game;

public class LoadSave {

    public static final String PLAYER_ATLAS = "\\resources\\player_sprites.png";
    public static final String LEVEL_ATLAS = "\\resources\\outside_sprites.png";
    public static final String LEVEL_ONE_DATA = "\\resources\\level_one_data.png";

    public static BufferedImage GetSpriteAtLas(String fileName) {
//use static method we cannot use getClass
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream(fileName);

        try { 
            img = ImageIO.read(is);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }

    public static int[][] GetLevelData(){
        int[][] lvlData = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];
        BufferedImage img = GetSpriteAtLas(LEVEL_ONE_DATA);
        

        for(int row = 0 ; row < img.getHeight() ; row++){
            for(int col = 0 ; col < img.getWidth() ; col++){
                Color color = new Color(img.getRGB(col, row));
                int value  = color.getRed();
                if(value >= 48){
                    value = 0;
                }
                lvlData[row][col] = value;
            }
        }
        return lvlData;
    }

}
