package items.weapons;

import gameObjects.GameObject;
import platformer.AttackEvent;

/**
 *
 * @author Charlie Hands
 */
public class Sword implements Weapon{
    private GameObject user;
    public Sword(GameObject user){
        this.user = user;
    }
    @Override
    public int attack(AttackEvent e) {
        return 20;
    }

    @Override
    public String getName() {
        return "Sword";
    }

    @Override
    public GameObject getUser() {
        return user;
    }
    
}
