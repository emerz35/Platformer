package items.weapons;

//import gameObjects.GameObject;
import gameObjects.GameObject;
import items.Item;
import platformer.AttackEvent;

/**
 *
 * @author Charlie Hands
 */
public interface Weapon extends Item{
    public float attack(AttackEvent e);
    //public GameObject getUser();
    @Override
    public default void useorequip(GameObject o){
        o.equipWeapon(this);
        o.removeItem(this);
    }
}
