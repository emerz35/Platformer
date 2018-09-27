package items.weapons;

import gameObjects.GameObject;
import items.Item;
import platformer.AttackEvent;

/**
 *
 * @author Charlie Hands
 */
public interface Weapon extends Item{
    public int attack(AttackEvent e);
    public GameObject getUser();
}
