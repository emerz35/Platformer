package items.armour;

import gameObjects.GameObject;
import platformer.AttackEvent;

/**
 *
 * @author Charlie Hands
 */
public class LeatherArmour implements Armour{

    @Override
    public void defend(AttackEvent e, float damage) {
        e.getDefender().changeHealth(-damage * 0.9f);
    }

    @Override
    public String getName() {
        return "Leather Armour";
    }

    @Override
    public void render(float x, float y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void useorequip(GameObject o) {
        o.equipArmour(this);
        o.removeItem(this);
    }
    
}
