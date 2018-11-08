package gameObjects;

import buffs.Effect;
import gameObjects.behaviours.MovementBehaviour;
import items.Item;
import items.armour.Armour;
import items.weapons.Weapon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
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
    private int invinc = 0;
    private Direction direction = Direction.stationary;
    private Direction facing = Direction.right;
    private final List<Effect> effects = new LinkedList<>();
    
    public enum Direction{
        left(-1),
        right(1),
        stationary(0);
        private final float multiplier;
        private Direction(float multiplier){
            this.multiplier = multiplier;
        }
        public float getMultiplier(){
            return multiplier;
        }
    }
    
    public GameObject(float x, float y, float width, float height, float health, Color color, Collision c, MovementBehaviour mb, Stage s, Weapon weapon, Armour armour, Direction direction){
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
        this.direction = direction;
    } 
    public GameObject(float x, float y, float width, float height, float health, Color color, Collision c, MovementBehaviour mb, Stage s){
        this.color = color;
        this.collision = c;
        this.movement = mb;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.stage = s;
        this.health = health;
    } 
    public GameObject(float x, float y, float width, float height,float health, Color color, MovementBehaviour mb, Stage s, Weapon weapon, Armour armour, Direction direction){
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
        this.direction = direction;
    }
    public GameObject(float x, float y, float width, float height,float health, Color color, MovementBehaviour mb, Stage s){
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
        if(invinc%10>5)g.setColor(Color.white);
        else g.setColor(color);
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
    public Stage getStage(){
        return this.stage;
    }
    public float getWidth(){
        return this.width;
    }
    public float getHeight(){
        return this.height;
    }
    public int getInvinc(){
        return invinc;
    }
    public void setInvincTo(int invinc){
        this.invinc = invinc;
    }
    public void setInvinc(){
        this.invinc = 60;
    }
    public void reduceInvinc(){
        invinc--;
    }
    public Direction getDirection(){
        return this.direction;
    }
    public void swapDirections(){
        if(direction != Direction.stationary) direction = direction == Direction.left ? Direction.right:Direction.left;
    }
    public void stopObject(){
        direction = Direction.stationary;
    }
    public void setDirection(String direction){
        switch(direction.toLowerCase()){
            case "left": this.direction = Direction.left;
                        break;
            case "right": this.direction = Direction.right;
                        break;
            default: this.direction = Direction.stationary;
        }
    }
    public void setDirection(Direction direction){
        this.direction = direction;
    }
    public void setFacing(String direction){
        switch(direction.toLowerCase()){
            case "left": this.facing = Direction.left;
                        break;
            case "right": this.facing = Direction.right;
                        break;
        }
    }
    public void setFacing(Direction direction){
        this.facing = direction;
    }
    public Direction getFacing(){
        return this.facing;
    }
    
    public List<Effect> getEffects(){
        return effects;
    }
    public void addEffect(Effect e){
        effects.add(e);
    }
    public void removeEffect(Effect e){
        effects.remove(e);
    }
    public Storage<Item> getItems(){
        return this.items;
    }
    public void addItem(Item i){
        items.add(i);
    }
    public void removeItem(Item i){
        items.remove(i);
    }
}   
