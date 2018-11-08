package items;

import gameObjects.GameObject;

/**
 *
 * @author Charlie Hands
 */
public interface Item {
    public String getName();
    public void render(float x, float y);
    public void useorequip(GameObject o);
}
