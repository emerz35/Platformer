package buffs;

import gameObjects.GameObject;

/**
 *
 * @author Charlie Hands
 */
public interface Effect {
    public int getTime();
    public void tick(GameObject o);
    public String getName();
}
