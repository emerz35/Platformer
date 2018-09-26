package platformer;

import items.armour.Armour;
import items.weapons.Weapon;

/**
 *
 * @author Charlie Hands
 */
public class AttackEvent {
    private Armour defender;
    private Weapon attacker;
    
    public Weapon getAttacker(){
        return attacker;
    }
    public Armour getDefender(){
        return defender;
    }
    public void attackEvent(){
        defender.defend(this,attacker.attack(this));
    }
}
