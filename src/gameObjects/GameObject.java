package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import platformer.Platformer;

/**
 *
 * @author Charlie Hands
 */
public abstract class GameObject extends Collision{
    protected float velx = 0, vely = 0;
    private boolean alive = true;
    private final Color color;
    private Image sprite;
    public GameObject(float x, float y, float width, float height, Color color){
        super(x,y, width,height);
        this.color = color;
    } 
    public void render(Graphics g){
        g.setColor(color);
        g.fillRect((int)x,(int) y, (int) width, (int) height);
    } 
    
    public abstract void tick();
    
   public float getVelX(){
        return velx;
    }
    public void setVelX(float velx){
        this.velx = velx;
    }
    public float getVelY(){
        return vely;
    }
    public void setVelY(float vely){
        this.vely = vely;
    } 
    public boolean isAlive(){
        return alive;
    }
    public void remove(){
        this.alive = false;
    }
    public void gravity(){
        this.setVelY(this.getVelY() + Platformer.GRAVITY);
    }
}
