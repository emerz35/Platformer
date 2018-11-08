package viewables;

import items.Item;
import java.awt.Graphics;
import platformer.Storage;

/**
 *
 * @author Charlie Hands
 */
public class InventoryViewable implements Viewable{
    private Storage<Item> items;
    public InventoryViewable(Storage<Item> items){
        this.items = items;
    }
    @Override
    public void onClick(int mx, int my) {
        
    }

    @Override
    public void highlight(int mx, int my) {
        
    }

    @Override
    public void render(Graphics g) {
        
    }

    @Override
    public void mouseDown(int mx, int my) {
    }
    
}
