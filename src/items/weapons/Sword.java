package items.weapons;

import java.awt.Color;
import java.awt.Graphics;
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
    public void render(float x, float y,Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int)x,(int)y,70,70);
    }
}
