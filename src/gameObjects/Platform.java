package gameObjects;

import gameObjects.behaviours.NoMovementBehaviour;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Charlie Hands
 */
public class Platform extends GameObject{

    public Platform(float x, float y, float width, float height) {
        super(x, y, width, height, Color.GRAY, new Collision(x,y,width,height), new NoMovementBehaviour());
    }

    @Override
    public void tick() {}
    
    @Override
    public void render(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect((int)x, (int) y, (int) width, (int) height - 1);
    }

    @Override
    public void collision(GameObject o) {
        o.setX(o.getX() - o.getVelX());
        o.setY(o.getY() - o.getVelY());
        yisFree(o.getVelY(),o);
        xisFree(o.getVelX(),o);
        o.setVelY(0);
    }
    private void xisFree(float velX, GameObject o){
        if(velX == 0) return;
        o.setX(o.getX() + velX);
        if(intersects(o)){
            o.setX(o.getX() - velX);
            xisFree(slow(velX, 1),o);
        }
    }
    private void yisFree(float velY,GameObject o){
        if(velY == 0) return;
        o.setY(o.getY() + velY);
        if(intersects(o)){
            o.setY(o.getY() - velY);
            yisFree(slow(velY, 1),o);
        }
    }
    
    private float slow(float vel, float deceleration){
        return vel > 0 ? vel - deceleration : vel + deceleration;
    }
}
