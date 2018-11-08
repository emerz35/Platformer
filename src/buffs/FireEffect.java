package buffs;

import gameObjects.GameObject;

/**
 *
 * @author Charlie Hands
 */
public class FireEffect implements Effect{
    private int timer = 300;
    @Override
    public void tick(GameObject o) {
        o.changeHealth(-0.02f);
    }  

    @Override
    public int getTime() {
        return this.timer;
    }

    @Override
    public void reduceTime() {
        timer --;
    }

    @Override
    public String getName() {
        return "on fire";
    }
}
