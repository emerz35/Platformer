package gameObjects;

import gameObjects.behaviours.MovementBehaviour;
import items.armour.LeatherArmour;
import items.weapons.Sword;
import java.awt.Color;
import platformer.AttackEvent;
import stages.Stage;

/**
 *
 * @author Charlie Hands
 */
public class Player extends GameObject{
    public Player(float x, float y, MovementBehaviour m, Stage s){
        super(x,y,32,32,100,Color.black,m,s, new Sword(), new LeatherArmour(),Direction.stationary);
    }
    @Override
    public void tick(){
        movement.tick(this);
        velx = Math.abs(xisFree(velx*getDirection().getMultiplier()));
        vely = yisFree(vely);
        //200,200,500,280   
        if((x>500&& getDirection() == Direction.right)||(x<200 && getDirection()== Direction.left))getStage().changeX(-velx*getDirection().getMultiplier());
        else x += velx * getDirection().getMultiplier();

        if((y>280&& vely>0)||(y<200 && vely<0))getStage().changeY(-vely);
        else y += vely;
       
        if(getInvinc() > 0) reduceInvinc();
        collision.setX(x);
        collision.setY(y);
        getEffects().removeIf(e -> e.getTime() <=0);
        getEffects().forEach(e -> {
            e.tick(this);
            e.reduceTime();
        });
    }
    @Override 
    public void collision(GameObject o){
        if(o instanceof Enemy && getInvinc() <= 0){ 
            new AttackEvent(o,this).attackEvent();
            setInvinc();
        }
    }
}
