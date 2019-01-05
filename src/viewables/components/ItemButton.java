package viewables.components;

import gameObjects.GameObject;
import items.Item;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Charlie
 */
public class ItemButton extends Button{
    private Item item;
    private int quantity;
    
    public ItemButton(String name, float x, float y, float width, float height, Color colour, Color onHover, Item item, GameObject owner) {
        super(name, x, y, width, height, colour, onHover, ()-> {if(item!=null)item.useorequip(owner);});
    }
    public void itemAction(ItemAction i){
        if(item != null)i.action(item);
        System.out.println(item.getName());
    }
    public void setItem(Item item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    public void removeItem(){
        this.item = null;
        this.quantity = 0;
    }
    @Override
    public void render(Graphics g){
        g.setColor(colour);
        g.fill3DRect((int)x,(int)y,(int)width,(int)height,true);
        if(item!=null)item.render(x, y, g);
    }
}
