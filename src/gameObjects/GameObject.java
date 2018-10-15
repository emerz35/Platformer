package gameObjects;

import gameObjects.behaviours.MovementBehaviour;
import items.Item;
import items.armour.Armour;
import items.weapons.Weapon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import platformer.AttackEvent;
import platformer.Storage;
import stages.Stage;

/**
 *
 * @author Charlie Hands
 */
public abstract class GameObject{
    protected float velx = 0, vely = 0,x,y,width,height;
    protected final Collision collision;
    private boolean alive = true;
    private final Color color;
    private Image sprite;
    protected MovementBehaviour movement;
    private Stage stage;
    public int jumps = 2;
    private final Storage<Item> items = new Storage();
    private Weapon weapon;
    private Armour armour;
    private float health;
    public GameObject(float x, float y, float width, float height, float health, Color color, Collision c, MovementBehaviour mb, Stage s, Weapon weapon, Armour armour){
        this.color = color;
        this.collision = c;
        this.movement = mb;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.stage = s;
        this.health = health;
        this.armour = armour;
        this.weapon = weapon;
    } 
    public GameObject(float x, float y, float width, float height,float health, Color color, MovementBehaviour mb, Stage s, Weapon weapon, Armour armour){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.collision = new Collision(x,y,width,height);
        this.color = color;
        this.movement = mb;
        this.stage = s;
        this.health = health;
        this.armour = armour;
        this.weapon = weapon;
    }public GameObject(float x, float y, float width, float height,float health, Color color, MovementBehaviour mb, Stage s){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.collision = new Collision(x,y,width,height);
        this.color = color;
        this.movement = mb;
        this.stage = s;
        this.health = health;
    }
    public void defend(AttackEvent e,float damage){
        armour.defend(e,damage);
    }
    public float attack(AttackEvent e){
        return weapon.attack(e);
    }
    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    public void equipArmour(Armour armour){
        this.armour = armour;
    }
    public void render(Graphics g){
        g.setColor(color);
        g.fillRect((int)x,(int) y, (int) width, (int) height);
    } 
    public void changeHealth(float change){
        health+=change;
    }
    public float getHealth(){
       return health; 
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
        return o.getCollision().intersects(this.collision);
    }
    public float xisFree(float velX){
        if(velX == 0) return 0;
        Collision c = new Collision(x + velX,y ,width,height);
        for(GameObject tempObject : stage.getObjects()){
                if(tempObject instanceof Platform && tempObject.getCollision().intersects(c)){
                    jumps = 2;    
                    return xisFree(slow(velX, 1));
                }
        }
        return velX;
	}
    public float yisFree(float velY){
        if(velY == 0) return 0;
        Collision c = new Collision(x, y + velY,width,height);
        for(GameObject tempObject: stage.getObjects()){
                if(tempObject instanceof Platform && tempObject.getCollision().intersects(c)){
                    jumps = 2;    
                    return yisFree(slow(velY,1));
                }
        }
        return velY;
    }
    public float slow(float vel, float deceleration){
            return vel > 0 ? vel - deceleration : vel + deceleration;
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
    public float getWidth(){
        return this.width;
    }
    public float getHeight(){
        return this.height;
    }
}
