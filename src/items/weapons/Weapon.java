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
    @Override
    public default void useorequip(GameObject o){
        Weapon old = o.equipWeapon(this);
        o.removeItem(this);
        o.addItem(old);
        System.out.println("ok");
    }
}
