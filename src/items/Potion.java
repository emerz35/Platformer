package items;

import effects.Effect;
import gameObjects.GameObject;
import java.awt.Graphics;

/**
 *
 * @author Charlie Hands
 */
public class Potion implements Item, Stackable{
    private final String name;
    private final Effect effect;
    private final int id;
    public Potion(String name, Effect effect, int id){
        this.name = name;
        this.effect = effect;
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void render(float x, float y,Graphics g) {
        
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void useorequip(GameObject o) {
        o.addEffect(effect);
        o.removeItem(this);
    }
    
}
