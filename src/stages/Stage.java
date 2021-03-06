package stages;

import gameObjects.GameObject;
import gameObjects.Player;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Charlie Hands
 */
public class Stage {
    private Image background;
    private List<GameObject> objects = new LinkedList();
    
    public List<GameObject> getObjects(){
        return objects;
    }
    
    public void render(){
        
    }
    public void tick(){
        objects.forEach(x -> x.tick());
        objects = objects.stream()
                .filter(x -> x.isAlive())
                .collect(Collectors.toList());
        objects.forEach(x -> collision(x));
    }
    private void collision(GameObject o){
        objects.stream().filter(x -> x.intersects(o)).forEach(x -> {
            o.collision(x);
            //System.out.println(o + " " + o.getX() + ", " + (o.getX() + o.getWidth()) + "; " + o.getY() + ", " + (o.getY() + o.getHeight()));
            });
    }
    
    public void addObject(GameObject o){
        objects.add(o);
    }
    /**
     * Removes any GameObject from the stage 
     * @param o the object to remove
     */
    public void removeObject(GameObject o){
        o.remove();
    }
    public void changeY(float dy){
        objects.stream().filter(x -> !(x instanceof Player)).forEach(x -> x.setY(x.getY() + dy));
    }
    public void changeX(float dx){
        objects.stream().filter(x -> !(x instanceof Player)).forEach(x -> x.setX(x.getX() + dx));
    }
    public Image getImage(){
        return background;
    }
}
