package viewables;

import gameObjects.Player;
import gameObjects.weaponObjects.MeleeObject;

import java.awt.Color;
import java.awt.Graphics;
import viewables.components.Button;

/**
 *
 * @author Charlie Hands
 */
public class GUIViewable implements Viewable{
    private final Player player;
    private final MeleeObject o;
    private final Button b;
    public GUIViewable(Player player,MeleeObject o, MenuHandler mh){
        this.b = new Button("",10,390,50,50,Color.GRAY,Color.YELLOW, ()->{mh.addViewable(new InventoryViewable(player,mh));});
        this.player = player;
        this.o = o;
        
    }
    @Override
    public void onClick(int mx, int my) {
        if(b.withinBounds(mx,my))b.onClick();
    }

    @Override
    public void highlight(int mx, int my) { 
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(10, 10, 100, 20);
        g.setColor(Color.green);
        g.fillRect(10,10,(int)player.getHealth(),20);
        b.render(g);
    }

    @Override
    public void mouseDown(int mx, int my) {
        o.attack();
    }
    
}
