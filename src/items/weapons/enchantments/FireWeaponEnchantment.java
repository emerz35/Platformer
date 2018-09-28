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
    public float attack(AttackEvent e) {
        //Add fire debuff to e.getDefender()
        return weapon.attack(e);
    }

    @Override
    public String getName() {
        return "Fiery " + weapon.getName();
    }

    @Override
    public void render(float x, float y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
