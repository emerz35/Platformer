package items.weapons.enchantments;

import gameObjects.GameObject;
import items.weapons.Weapon;
import platformer.AttackEvent;

/**
 *
 * @author Charlie Hands
 */
public class FireWeaponEnchantment implements Weapon{
    private final Weapon weapon;
    private final GameObject user;
    public FireWeaponEnchantment(Weapon w, GameObject user){
        this.weapon = w;
        this.user = user;
    }
    @Override
    public int attack(AttackEvent e) {
        //Add fire debuff to e.getDefender().getUser()
        return weapon.attack(e);
    }

    @Override
    public String getName() {
        return "Fiery " + weapon.getName();
    }

    @Override
    public GameObject getUser() {
        return user;
    }
    
}
