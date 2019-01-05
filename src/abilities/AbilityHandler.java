package abilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Charlie
 */
public class AbilityHandler extends KeyAdapter{
    private final List<Ability> abilities = new LinkedList<>();
    
    public AbilityHandler(Ability... abilities){
        this.abilities.addAll(Arrays.asList(abilities));
    }
    public void addAbility(Ability ability){
        abilities.add(ability);
    }
    public void removeAbility(Ability ability){
        abilities.remove(ability);
    }
    @Override
    public void keyPressed(KeyEvent e){
        abilities.forEach(x -> {
            if(x.hasPressed(e.getKeyCode()))x.start();
        });
    }
}
