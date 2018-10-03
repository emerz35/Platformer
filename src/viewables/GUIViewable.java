package viewables;

import gameObjects.Player;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Charlie Hands
 */
public class GUIViewable implements Viewable{
    private final Player player;
    public GUIViewable(Player player){
        this.player = player;
    }
    @Override
    public void onClick(int mx, int my) {
    }

    @Override
    public void highlight(int mx, int my) { 
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(10,10,(int)player.getHealth(),20);
    }
    
}
