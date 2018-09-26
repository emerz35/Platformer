package items.weapons;

import items.Item;
import platformer.AttackEvent;

/**
 *
 * @author Charlie Hands
 */
public interface Weapon extends Item{
    public int attack(AttackEvent e);
}
