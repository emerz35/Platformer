package viewables;

import gameObjects.Player;
import gameObjects.weaponObjects.MeleeObject;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Charlie Hands
 */
public class GUIViewable implements Viewable{
    private final Player player;
    private final MeleeObject o;
    private Button b = new Button();
    public GUIViewable(Player player,MeleeObject o){
        this.player = player;
        this.o = o;
        
    }
    @Override
    public void onClick(int mx, int my) {
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
    }

    @Override
    public void mouseDown(int mx, int my) {
        o.attack();
    }
    
}
