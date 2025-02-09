package inputs;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import gamestates.Gamestate;
import main.GamePanel;

public class MouseInputs implements MouseListener , MouseMotionListener{

    @SuppressWarnings("unused")
    private GamePanel gamePanel;

    public MouseInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       // gamePanel.setRectPos(e.getX(), e.getY());
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (Gamestate.state) {
            case MENU:
                gamePanel.getGame().getMenu().mouseClick(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().mouseClick(e);
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
