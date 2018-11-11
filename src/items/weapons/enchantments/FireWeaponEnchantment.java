package items.weapons.enchantments;

import effects.FireEffect;
import gameObjects.GameObject;
import items.weapons.Weapon;
import platformer.AttackEvent;

/**
 *
 * @author Charlie Hands
 */
public class FireWeaponEnchantment implements Weapon{
    private final Weapon weapon;
    public FireWeaponEnchantment(Weapon w){
        this.weapon = w;
    }
    @Override
    public float attack(AttackEvent e) {
        e.getDefender().addEffect(new FireEffect());
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
