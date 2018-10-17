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
    private int attackFrames = 0;
    public MeleeObject(float x, float y, float width, float height, float health, Color color, MovementBehaviour mb, Stage s, Player player) {
        super(x, y, width, height, health, color, mb, s);
        this.player = player;
    }

    @Override
    public void tick() {
        movement.tick(this);
        collision.setX(x);
        collision.setY(y);
        if(attackFrames > 0) {
            x = player.getX() - getWidth()/2 + player.getWidth()/2 + player.getWidth()/2 * player.getFacing().getMultiplier();
            attackFrames--;
        }
        else x = player.getX() + player.getWidth()/2 - getWidth()/2;
        y = player.getY();
    }
    @Override
    public void render(Graphics g){

    }

    @Override
    public void collision(GameObject o) {
        if(o instanceof Enemy && attackFrames > 0 && o.getInvinc() <=0){
            new AttackEvent(player,o).attackEvent();
            o.setInvinc();
        }
    }
    public void attack(){
        this.attackFrames = 20;
    }
    
}
