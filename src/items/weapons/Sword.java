package items.weapons;

import platformer.AttackEvent;

/**
 *
 * @author Charlie Hands
 */
public class Sword implements Weapon{

    @Override
    public int attack(AttackEvent e) {
        return 20;
    }

    @Override
    public String getName() {
        return "Sword";
    }
    
}
