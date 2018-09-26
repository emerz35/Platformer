package gameObjects.behaviours;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import platformer.Platformer;

/**
 *
 * @author Charlie Hands
 */
public class PlayerMovementBehaviour extends KeyAdapter implements MovementBehaviour{
    Platformer game;
    public PlayerMovementBehaviour(Platformer p){
        this.game = p;
    }
    boolean[] keys = new boolean[]{false,false};
    @Override
    public void tick() {
        if(keys[0] && keys[1]) game.getPlayer().setVelX(0);
        else if(keys[0]) game.getPlayer().setVelX(5);
        else if(keys[1]) game.getPlayer().setVelX(-5);
        else game.getPlayer().setVelX(0);
        game.getPlayer().setVelY(game.getPlayer().getVelY() + Platformer.GRAVITY);
    }
    @Override 
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_SPACE && game.getPlayer().jumps > 0){
            game.getPlayer().setVelY(-15); 
            game.getPlayer().jumps--;
        }
        else if(e.getKeyCode() == KeyEvent.VK_D)keys[0] = true;
        else if(e.getKeyCode() == KeyEvent.VK_A)keys[1] = true;
    }
    @Override
    public void keyReleased(KeyEvent e){
       if(e.getKeyCode() == KeyEvent.VK_D)keys[0] = false;
       else if(e.getKeyCode() == KeyEvent.VK_A)keys[1] = false;
    }
}
