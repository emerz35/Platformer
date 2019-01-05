package items.weapons.enchantments;

import effects.FireEffect;
import items.weapons.Weapon;
import java.awt.Color;
import java.awt.Graphics;
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
    public void render(float x, float y,Graphics g) {
        weapon.render(x,y,g);
        g.setColor(Color.blue);
        g.fillRect((int)x+2,(int)y+2,65,65);
    }
}
