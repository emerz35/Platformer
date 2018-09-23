package gameObjects;

/**
 *
 * @author Charlie Hands
 */
public class Collision {
    protected float x,y,width,height;
    private final int id;
    private static int idBuilder = 0;
    public Collision(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = getNewID();
    }
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
    public boolean intersects(Collision o){
        return id != o.getID() && x >= o.x - width && x <= o.x + o.width && y >= o.y - height && y <= o.y + o.height;
    }    
    private static int getNewID(){
        idBuilder++;
        return idBuilder;
    }
    public int getID(){
        return id;
    }
}
