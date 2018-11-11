package viewables;

import items.Item;
import java.awt.Color;
import java.awt.Graphics;
import platformer.Storage;

/**
 *
 * @author Charlie Hands
 */
public class InventoryViewable implements Viewable{
    private final Storage<Item> items;
    private final MenuHandler menuHandler;
    public InventoryViewable(Storage<Item> items, MenuHandler mh){
        this.items = items;
        this.menuHandler = mh;
    }
    @Override
    public void onClick(int mx, int my) {
        if(mx>770||mx<30||my<20||my>420)menuHandler.removeCurrentViewable();
    }

    @Override
    public void highlight(int mx, int my) {
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fill3DRect(30, 20, 740, 400, true);
    }

    @Override
    public void mouseDown(int mx, int my) {
    }
    
}
