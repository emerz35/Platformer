package gameObjects;

import gameObjects.behaviours.MovementBehaviour;
import items.armour.LeatherArmour;
import items.weapons.Sword;
import items.weapons.enchantments.FireWeaponEnchantment;
import java.awt.Color;
import stages.Stage;

/**
 *
 * @author Charlie Hands
 */
public class Enemy extends GameObject{

    public Enemy(float x, float y, float width, float height, float health, Color color, MovementBehaviour mb, Stage s) {
        super(x, y, width, height, health, color, mb, s, new FireWeaponEnchantment(new Sword()), new LeatherArmour(),Direction.left);
    }

    @Override
    public void tick() {
        velx = xisFree(velx*getDirection().getMultiplier()) * getDirection().getMultiplier();
        vely = yisFree(vely);
        x += velx * getDirection().getMultiplier();
        y += vely;
        movement.tick(this);
        collision.setX(x);
        collision.setY(y);
        if(getHealth() <= 0) remove();
        if(getInvinc()>0)reduceInvinc();
    }

    @Override
    public void collision(GameObject o) { 
    }
    
}
