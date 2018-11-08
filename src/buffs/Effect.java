package buffs;

import gameObjects.GameObject;

/**
 *
 * @author Charlie Hands
 */
public interface Effect {
    public int getTime();
    public void reduceTime();
    public void tick(GameObject o);
}
