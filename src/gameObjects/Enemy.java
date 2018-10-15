package gameObjects;

import gameObjects.behaviours.MovementBehaviour;
import items.armour.LeatherArmour;
import items.weapons.Sword;
import java.awt.Color;
import stages.Stage;

/**
 *
 * @author Charlie Hands
 */
public class Enemy extends GameObject{

    public Enemy(float x, float y, float width, float height, float health, Color color, MovementBehaviour mb, Stage s) {
        super(x, y, width, height, health, color, mb, s, new Sword(), new LeatherArmour());
    }

    @Override
    public void tick() {
        x += velx;
        y += vely;
        movement.tick(this);
        collision.setX(x);
        collision.setY(y);
    }

    @Override
    public void collision(GameObject o) { 
    }
    
}
