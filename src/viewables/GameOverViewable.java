package viewables;

import java.awt.Color;
import java.awt.Graphics;
import viewables.components.Button;

/**
 *
 * @author Charlie Hands
 */
public class GameOverViewable implements Viewable{
    private final Button replay;
    private final MenuHandler menuHandler;
    public GameOverViewable(MenuHandler mh){
        menuHandler = mh;
        replay = new Button("Replay",275,150,200,100,Color.LIGHT_GRAY, Color.YELLOW,()->menuHandler.removeCurrentViewable());
    }
    @Override
    public void onClick(int mx, int my) {
        if(replay.withinBounds(mx,my))replay.onClick();
    }

    @Override
    public void highlight(int mx, int my) {
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 480);
        replay.render(g);
    }

    @Override
    public void mouseDown(int mx, int my) {
    }
    
}
