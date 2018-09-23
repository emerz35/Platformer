package gameObjects;

import gameObjects.behaviours.MovementBehaviour;
import java.awt.Color;
import platformer.Platformer;

/**
 *
 * @author Charlie Hands
 */
public class Player extends GameObject{
    public int jumps = 2;
    public Player(float x, float y, MovementBehaviour m){
        super(x,y,32,32,Color.black,new Collision(x,y,32,32),m);
        this.movement = m;
    }
    @Override
    public void tick(){
        movement.tick();
        x += velx;
        y += vely;
        y = Platformer.clamp(y,0,420);
        if(y==420) {
            vely = 0;
            jumps = 2;
        }
    }
    @Override 
    public void collision(GameObject c){
        if(c instanceof Platform) jumps=2;
    }
}
