package items.armour;

import items.Item;
import platformer.AttackEvent;

/**
 *
 * @author Charlie Hands
 */
public interface Armour extends Item{
    public void defend(AttackEvent e, float damage);
}
