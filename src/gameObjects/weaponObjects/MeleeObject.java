
package gameObjects.weaponObjects;

import gameObjects.Enemy;
import gameObjects.GameObject;
import gameObjects.Player;
import gameObjects.behaviours.MovementBehaviour;
import java.awt.Color;
import java.awt.Graphics;
import platformer.AttackEvent;
import stages.Stage;

/**
 *
 * @author Charlie Hands
 */
public class MeleeObject extends GameObject{
    private final Player player;
    public MeleeObject(float x, float y, float width, float height, float health, Color color, MovementBehaviour mb, Stage s, Player player) {
        super(x, y, width, height, health, color, mb, s);
        this.player = player;
    }

    @Override
    public void tick() {
        movement.tick(this);
        collision.setX(x);
        collision.setY(y);
    }
    @Override
    public void render(Graphics g){
        
    }

    @Override
    public void collision(GameObject o) {
        if(o instanceof Enemy){
            new AttackEvent(player,o).attackEvent();
        }
    }
    
}
