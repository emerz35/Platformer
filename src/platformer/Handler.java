package platformer;
import gameObjects.GameObject;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author Charlie Hands
 */
public class Handler {
    private final LinkedList<GameObject> objects = new LinkedList<>();
    
    public void render(Graphics g){
        objects.removeIf(x -> !x.isAlive());
        objects.forEach(x -> x.render(g));
    }
    
    public void addObject(GameObject o){
        objects.add(o);
    }
    /**
     * Removes any GameObject from the handler 
     * @param o the object to remove
     */
    public void removeObject(GameObject o){
        o.remove();
    }
}
