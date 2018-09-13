package gameObjects;

import java.awt.Color;
import platformer.Platformer;

/**
 *
 * @author Charlie Hands
 */
public class Player extends GameObject{
    public boolean[] keys = new boolean[]{false,false};
    public int jumps = 2;
    public Player(float x, float y){
        super(x,y,32,32, Color.black);
    }
    @Override
    public void tick(){
        x += velx;
        y += vely;
        if(keys[0] && keys[1]) velx = 0;
        else if(keys[0]) velx = 5;
        else if(keys[1]) velx = -5;
        else velx = 0;
        gravity();
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
