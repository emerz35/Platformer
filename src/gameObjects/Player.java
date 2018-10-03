package gameObjects;

import gameObjects.behaviours.MovementBehaviour;
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
        super(x,y,32,32,100,Color.black,new Collision(x,y,32,32),m,s);
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
    }
    @Override 
    public void collision(GameObject o){
        if(o instanceof Enemy) new AttackEvent(o,this).attackEvent();
    }
}
