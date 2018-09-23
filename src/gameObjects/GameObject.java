package gameObjects;

import gameObjects.behaviours.MovementBehaviour;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Charlie Hands
 */
public abstract class GameObject{
    protected float velx = 0, vely = 0,x,y,width,height;
    private final Collision collision;
    private boolean alive = true;
    private final Color color;
    private Image sprite;
    protected MovementBehaviour movement;
    public GameObject(float x, float y, float width, float height, Color color, Collision c, MovementBehaviour mb){
        this.color = color;
        this.collision = c;
        this.movement = mb;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    } 
    public void render(Graphics g){
        g.setColor(color);
        g.fillRect((int)x,(int) y, (int) width, (int) height);
    } 
    
    public abstract void tick();
    public abstract void collision(GameObject o);
    
    public float getX(){
        return x;
    }
    public void setX(float x){
        this.x = x;
    }
    public float getY(){
        return y;
    }
    public void setY(float y){
        this.y = y;
    }
    
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
    public Collision getCollision(){
        return this.collision;
    }
    public boolean intersects(GameObject o){
        return collision.intersects(o.getCollision());
    }
}
