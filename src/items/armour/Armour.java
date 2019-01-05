package items.armour;

import gameObjects.GameObject;
import items.Item;
import platformer.AttackEvent;

/**
 *
 * @author Charlie Hands
 */
public interface Armour extends Item{
    public void defend(AttackEvent e, float damage);
    
    @Override
    public default void useorequip(GameObject o){
        Armour old = o.equipArmour(this);
        o.removeItem(this);
        o.addItem(old);
    }
}
