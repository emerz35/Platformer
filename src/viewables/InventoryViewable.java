package viewables;

import gameObjects.GameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import viewables.components.Button;
import viewables.components.ItemAction;

/**
 *
 * @author Charlie Hands
 */
public class InventoryViewable implements Viewable{
    private final GameObject player;
    private final MenuHandler menuHandler;
    private final List<Button> buttons = new LinkedList<>();
    private final ItemAction purpose;
    
    public InventoryViewable(GameObject player, MenuHandler mh){
        this.player = player;
        this.menuHandler = mh;
        for(int i = 0;i < player.getItems().getCapacity();i++){
            final int j = i;
            buttons.add(new Button("",200 + (i % 5) * 75,110 + i/5 * 75, 70, 70,Color.LIGHT_GRAY,Color.LIGHT_GRAY,()->itemClick(j)));
        }
        this.purpose = x->{x.useorequip(player);};
    }
    public InventoryViewable(GameObject player, MenuHandler mh, ItemAction purpose){
        this.player = player;
        this.menuHandler = mh;
        for(int i = 0;i < player.getItems().getCapacity();i++){
            final int j = i;
            buttons.add(new Button("",200 + (i % 5) * 75,110 + i/5 * 75, 70, 70,Color.LIGHT_GRAY,Color.LIGHT_GRAY,()->itemClick(j)));
        }
        this.purpose = purpose;
    }
    @Override
    public void onClick(int mx, int my) {
        if(mx>620||mx<150||my<20||my>420)menuHandler.removeCurrentViewable();
        buttons.forEach(x-> {
            if(x.withinBounds(mx, my))x.onClick();
        });
    }

    @Override
    public void highlight(int mx, int my) {
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fill3DRect(150, 20, 470, 400, true);
        
        g.fill3DRect(200, 35, 70, 70, true);
        
        g.fill3DRect(275, 35, 70, 70, true);
        g.fill3DRect(350, 35, 70, 70, true);
        player.getWeapon().render(200, 35, g);
        buttons.forEach(x->x.render(g));
        //for(Item item:items.keySet())
        for(int i = 0;i < player.getItems().getItems().size();i++){
           player.getItems().getItems().get(i).render(200 + (i % 5) * 75,110 + i/5 * 75,g);
        }
    }

    @Override
    public void mouseDown(int mx, int my) {
    }
    public final void itemClick(int i){
        if(player.getItems().getItems().size()>i)purpose.action(player.getItems().getItems().get(i));
    }
}
