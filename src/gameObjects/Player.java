package gameObjects;

import gameObjects.behaviours.MovementBehaviour;
import items.armour.LeatherArmour;
import items.weapons.Sword;
import java.awt.Color;
import platformer.AttackEvent;
import platformer.Platformer;
import stages.Stage;

/**
 *
 * @author Charlie Hands
 */
public class Player extends GameObject{
    public Player(float x, float y, MovementBehaviour m, Stage s){
        super(x,y,32,32,100,Color.black,new Collision(x,y,32,32),m,s, new Sword(), new LeatherArmour());
    }
    @Override
    public void tick(){
        movement.tick(this);
        velx = xisFree(velx);
        vely = yisFree(vely);
        x += velx;
        y += vely;
        y = Platformer.clamp(y,0,420);
        if(y==420) {
            vely = 0;
            jumps = 2;
        }
        if(getInvinc() > 0) reduceInvinc();
        collision.setX(x);
        collision.setY(y);
    }
    @Override 
    public void collision(GameObject o){
        if(o instanceof Enemy && getInvinc() <= 0){ 
            new AttackEvent(o,this).attackEvent();
            setInvinc();
        }
    }
}
