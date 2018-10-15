package gameObjects.behaviours;

import gameObjects.GameObject;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import platformer.Platformer;

/**
 *
 * @author Charlie Hands
 */
public class PlayerMovementBehaviour extends KeyAdapter implements MovementBehaviour{
    
    boolean[] keys = new boolean[]{false,false,false};
    @Override
    public void tick(GameObject o) {
        if(keys[0] && keys[1]) o.setVelX(0);
        else if(keys[0]) o.setVelX(5);
        else if(keys[1]) o.setVelX(-5);
        else o.setVelX(0);
        if(keys[2] && o.jumps > 0) {
            o.setVelY(-15);
            o.jumps--;
            keys[2] = false;
        }
        o.setVelY(o.getVelY() + Platformer.GRAVITY);
    }
    @Override 
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                keys[2] = true;
                break;
            case KeyEvent.VK_D:
                keys[0] = true;
                break;
            case KeyEvent.VK_A:
                keys[1] = true;
                break;
            default:
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D:
                keys[0] = false;
                break;
            case KeyEvent.VK_A:
                keys[1] = false;
                break;
            case KeyEvent.VK_SPACE:
                keys[2] = false;
                break;
            default:
                break;
        }
    }
}
