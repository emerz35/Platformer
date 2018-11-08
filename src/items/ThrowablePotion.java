/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import buffs.Effect;
import gameObjects.GameObject;

/**
 *
 * @author Charlie Hands
 */
public class ThrowablePotion extends Potion{
    
    public ThrowablePotion(String name, Effect effect, int id) {
        super(name, effect, id);
    }
    
    @Override
    public void useorequip(GameObject o){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
