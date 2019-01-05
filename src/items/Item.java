package items;

import gameObjects.GameObject;
import java.awt.Graphics;

/**
 *
 * @author Charlie Hands
 */
public interface Item {
    public String getName();
    public void render(float x, float y, Graphics g);
    public void useorequip(GameObject o);
}
