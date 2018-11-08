package items.weapons;

import gameObjects.GameObject;
import platformer.AttackEvent;

/**
 *
 * @author Charlie Hands
 */
public class Sword implements Weapon{
    @Override
    public float attack(AttackEvent e) {
        return 20;
    }

    @Override
    public String getName() {
        return "Sword";
    }

    @Override
    public void render(float x, float y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
