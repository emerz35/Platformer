package platformer;
import gameObjects.GameObject;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 *
 * @author Charlie Hands
 */
public class Handler {
    private final LinkedList<GameObject> objects = new LinkedList<>();
    public void tick(){
        objects.forEach(x -> x.tick());
        objects.stream()
                .filter(x -> x.isAlive())
                .collect(Collectors.toList());
        objects.forEach(x -> collision(x));
    }
    private void collision(GameObject o){
        objects.stream().filter(x -> !x.equals(o)).forEach(x -> {
            if(o.intersects(x)) o.collision(x);
            });
    }
    public void render(Graphics g){
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
